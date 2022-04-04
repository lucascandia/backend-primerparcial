package com.example.tp.services;


import com.example.tp.entitiesModelo.*;
import com.example.tp.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsoPuntoSerImpl extends BaseServiceImpl<UsodePuntosCabec, Long> implements UsoPuntosService{
    public UsoPuntoSerImpl(BaseRepository<UsodePuntosCabec, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private ConceptosdePuntosRepository requerido;

    @Autowired
    private BolsaPuntosRepository bolsa;

    @Autowired
    private DetalleRepositiry deta;

    @Autowired
    private UsoPuntosCabRepository cabecera;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JavaMailSender mailSender;

    //Pasamos por parametro: destinatario, asunto y el mensaje
    public void sendEmail(String to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        mailSender.send(email);
    }

    @Override
    public UsodePuntosCabec consumo(UsodePuntosCabec entity) throws Exception {
        try {
            int indice=0;
            List<Integer> ids= new ArrayList<>();
            //Optenemos la clase que contiene los puntos que requerimos para el uso del vale
            ConceptosdePuntos puntoReque= requerido.puntosRequerido(entity.getConcepto_uso());
            int puntoNesecario= puntoReque.getPuntos_requerido();

            //Optenemos todas las bolsas de puntos que tiene el cliente
            List<BolsadePuntos> bolsaCliente= bolsa.busq(entity.getCliente_id(), 0, 0);

            for(int i=0; i<bolsaCliente.size(); i++){
                puntoNesecario= puntoNesecario - bolsaCliente.get(i).getSaldo_puntos();
                if(puntoNesecario>= 0){
                    ids.add((int)(long)bolsaCliente.get(i).getId());
                }else{
                    indice=i;
                    i=bolsaCliente.size();
                    break;

                }
            }

            if(puntoNesecario>0){
                throw new Exception("No cuenta con los puntos suficiente");
            }else if(ids.size()>0){
                for(int j=0; j< ids.size(); j++){
                    bolsa.deleteById(Long.valueOf(ids.get(j)));
                }
            }
            if(puntoNesecario != 0){
                int puntoSobra= bolsaCliente.get(indice).getSaldo_puntos()-Math.abs(puntoNesecario);
                bolsaCliente.get(indice).setPuntaje_utilizado(puntoSobra);
                bolsaCliente.get(indice).setSaldo_puntos(Math.abs(puntoNesecario));

                Optional<BolsadePuntos> entityOptional= bolsa.findById(bolsaCliente.get(indice).getId());
                // Creamos un nuevo modelo a la cual recibimos como entity
                BolsadePuntos entityUpdate= entityOptional.get();
                // actualizamos el cliente actualizado
                entityUpdate= bolsa.save(bolsaCliente.get(indice));
            }

            entity.setPuntaje_utilizado(puntoReque.getPuntos_requerido());

            LocalDateTime date_of_today = LocalDateTime.now();
            DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = date_of_today.format(format_date_of_today);

            String[] fechaSeparada = formattedDate.split("-");
            LocalDate date2 = LocalDate.of(Integer.parseInt(fechaSeparada[0]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[2]));
            Date date = java.sql.Date.valueOf(date2);

            entity.setFecha(date);

            baseRepository.save(entity);

            Detalle detalle= new Detalle();
            detalle.setPuntaje_utilizado(puntoReque.getPuntos_requerido());
            detalle.setId_bolsa(bolsaCliente.get(indice).getId());
            detalle.setId_cabecera(entity.getId());
            deta.save(detalle);

            List<Cliente> cliente= new ArrayList<>();

            Optional<Cliente> entityOptional= clienteRepository.findById((long) entity.getCliente_id());
            cliente.add(entityOptional.get());

            String mensaje= "Usted canjeo su puntos en "+ entity.getConcepto_uso()+ " y utilizó "+ entity.getPuntaje_utilizado()+" puntos";

            sendEmail(cliente.get(0).getEmail(),"Voleta de comprobante", mensaje);

            return entity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<UsodePuntosCabec> usoPuntos(String concepto, java.util.Date fecha, int idcliente) throws Exception {
        try {
            List<UsodePuntosCabec> usoPun= cabecera.usoPuntos(concepto, fecha, idcliente);
            return usoPun;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
