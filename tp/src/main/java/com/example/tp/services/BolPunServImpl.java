package com.example.tp.services;

import com.example.tp.entitiesModelo.AsignaciondePuntos;
import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.entitiesModelo.Cliente;
import com.example.tp.entitiesModelo.VencimientodePuntos;
import com.example.tp.repositorios.AsignaciondePuntosRepository;
import com.example.tp.repositorios.BaseRepository;
import com.example.tp.repositorios.BolsaPuntosRepository;
import com.example.tp.repositorios.VencimientodePuntosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
@Service
public class BolPunServImpl extends BaseServiceImpl<BolsadePuntos, Long> implements BolsaPuntosService{
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Autowired
    private VencimientodePuntosRepository duracion;

    @Autowired
    private BolsaPuntosRepository bolsa;

    @Autowired
    private AsignaciondePuntosRepository puntos;

    public BolPunServImpl(BaseRepository<BolsadePuntos, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public BolsadePuntos guardar(BolsadePuntos entity) throws Exception {
        try{
            //calcular la fecha de vencimiento
            VencimientodePuntos ven= duracion.busqueda(entity.getFecha_asignacion());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(entity.getFecha_asignacion());

            //String fecha = String.valueOf(entity.getFecha_asignacion());
            String[] fechaSeparada = fecha.split("-");
            LocalDate date2 = LocalDate.of(Integer.parseInt(fechaSeparada[0]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[2]));
            date2 = date2.plusDays(ven.getDias_duracion()+1);
            Date date = java.sql.Date.valueOf(date2);
            entity.setFecha_caducidad(date);
            //fin del calculo de la fecha de vencimiento

            // calculo de puntos
            AsignaciondePuntos puntostotal = puntos.calculo(entity.getMonto_operacion());
            //fin del calculo
            //calculo de puntaje utilizado
            entity.setPuntaje_asignado(0);
            //fin del calculo asignado
            //calculo de saldo
            entity.setSaldo_puntos(puntostotal.getMonto_equi());
            entity.setPuntaje_asignado(puntostotal.getMonto_equi());
            //fin del calculo saldo
            entity= baseRepository.save(entity);
            return entity;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<BolsadePuntos> busq(int id, int ini, int fin) throws Exception {
        try {
            List<BolsadePuntos> bolsapun= bolsa.busq(id, ini, fin);
            //Ordenamos la lista con respecto a su fecha de caducidad
            Collections.sort(bolsapun, (o1, o2) -> {
                if (o1.getFecha_caducidad() == null || o2.getFecha_caducidad() == null)
                    return 0;
                return o1.getFecha_caducidad().compareTo(o2.getFecha_caducidad());
            });

            return bolsapun;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<BolsadePuntos> dias(java.util.Date fecha) throws Exception {
        try {
            List<BolsadePuntos> bol= bolsa.diasVencer(fecha);
            return bol;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Scheduled(fixedDelay = HORA)
    public void limpiezaHora(){
        List<BolsadePuntos> bol= bolsa.findAll();

        LocalDateTime date_of_today = LocalDateTime.now();
        DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date_of_today.format(format_date_of_today);

        String[] fechaSeparada = formattedDate.split("-");
        LocalDate date2 = LocalDate.of(Integer.parseInt(fechaSeparada[0]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[2]));
        Date date = java.sql.Date.valueOf(date2);

        for(int i=0; i< bol.size(); i++){
            if(bol.get(i).getFecha_caducidad()== date){
                bolsa.deleteById(bol.get(i).getId());
            }
        }
    }

}
