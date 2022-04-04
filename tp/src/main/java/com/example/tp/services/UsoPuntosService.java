package com.example.tp.services;

import com.example.tp.entitiesModelo.UsodePuntosCabec;

import java.util.Date;
import java.util.List;

public interface UsoPuntosService extends BaseService<UsodePuntosCabec, Long>{
    UsodePuntosCabec consumo(UsodePuntosCabec entity) throws Exception;
    List<UsodePuntosCabec> usoPuntos(String concepto, Date fecha, int idcliente) throws Exception;

}
