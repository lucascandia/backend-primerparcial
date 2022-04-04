package com.example.tp.services;

import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.entitiesModelo.Cliente;
import com.example.tp.entitiesModelo.VencimientodePuntos;
import com.example.tp.repositorios.BaseRepository;
import com.example.tp.repositorios.BolsaPuntosRepository;
import com.example.tp.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Acá se realiza todas las operaciones de los query
@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{
    //Para acceder al repositorio especifico de cliente,
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BolsaPuntosRepository bolsa;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository){
        super(baseRepository);
    }


    @Override
    public List<Cliente> search(String nombre, String apellido, String cumple) throws Exception {
        try {
            List<Cliente> cliente= clienteRepository.search(nombre, apellido, cumple);
            return cliente;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<Cliente> diasVencer(int dias) throws Exception {
        try {
            List<Cliente> cliente= new ArrayList<>();

            LocalDateTime date_of_today = LocalDateTime.now();
            DateTimeFormatter format_date_of_today = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = date_of_today.format(format_date_of_today);

            String[] fechaSeparada = formattedDate.split("-");
            LocalDate date2 = LocalDate.of(Integer.parseInt(fechaSeparada[0]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[2]));
            date2 = date2.plusDays(dias);
            Date date = java.sql.Date.valueOf(date2);

            //Calculos la fecha exacta dentro x dias
            //LocalDate date2 = LocalDate.of(2022, 04, 03);

            //Buscamos todas las fechas en la bolsa que sea igual a la fecha calculada
            List<BolsadePuntos> bol= bolsa.diasVencer(date);

            List<Integer> idCliente= new ArrayList<>();

            // Almacenamos todos los ids cliente que tenga esa fecha a vencer
            for(int i=0; i< bol.size(); i++){
                idCliente.add(bol.get(i).getId_cliente());
            }
            //Eliminamos ids repetidos
            Set<Integer> hashSet= new HashSet<>(idCliente);
            idCliente.clear();
            idCliente.addAll(hashSet);

            for(int j=0; j<idCliente.size(); j++){
                Optional<Cliente> entityOptional= baseRepository.findById(Long.valueOf(idCliente.get(j)));
                cliente.add(entityOptional.get());
                //cliente.add(clienteRepository.getById(Long.valueOf(idCliente.get(j))));
            }

            return cliente;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
