package com.example.tp;

import com.example.tp.controllers.BaseControllerImpl;
import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.entitiesModelo.VencimientodePuntos;
import com.example.tp.repositorios.VencimientodePuntosRepository;
import com.example.tp.services.BolPunServImpl;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class TpApplication {/*extends BaseControllerImpl<BolsadePuntos, BolPunServImpl> {*/

    @Autowired
    private static VencimientodePuntosRepository duracion;

    public static void main(String[] args) {/*
        Date date1, inicio1;
        BolsadePuntos entity= new BolsadePuntos();
        LocalDate inicio = LocalDate.of(2022,07,20);
        inicio1=  java.sql.Date.valueOf(inicio);
        entity.setFecha_asignacion(inicio1);
        entity.setMonto_operacion(300000);
        VencimientodePuntos ven = duracion.busqueda(entity.getFecha_asignacion());
        ven.setDias_duracion(50);
        String fecha = String.valueOf(entity.getFecha_asignacion());
        String[] fechaSeparada = fecha.split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(fechaSeparada[2]), Integer.parseInt(fechaSeparada[1]), Integer.parseInt(fechaSeparada[0]));
        date = date.plusDays(ven.getDias_duracion());
        date1= java.sql.Date.valueOf(date);
        entity.setFecha_caducidad(date1);
        //fin del calculo de la fecha de vencimiento
        // calculo de puntos
        entity.setPuntaje_asignado(entity.getMonto_operacion() / 30000);
        //fin del calculo
        //calculo de puntaje utilizado
        entity.setPuntaje_asignado(0);
        //fin del calculo asignado
        //calculo de saldo
        entity.setSaldo_puntos(entity.getMonto_operacion() / 30000);
        //fin del calculo saldo
        //entity = baseRepository.save(entity);
        System.out.println(entity);*/
    }
    /*
    public static void main(String[] args) throws Exception {
        BolsadePuntos bolsa= new BolsadePuntos();
        bolsa.setFecha_asignacion("20/07/2022");
        bolsa.setMonto_operacion(300000);
        BolPunServImpl contr= new BolPunServImpl();
        BolPunServImpl.guardar(bolsa);
    }*/
}
