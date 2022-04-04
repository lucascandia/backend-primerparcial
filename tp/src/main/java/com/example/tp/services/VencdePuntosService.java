package com.example.tp.services;

import com.example.tp.entitiesModelo.VencimientodePuntos;

import java.util.Date;

public interface VencdePuntosService extends BaseService<VencimientodePuntos, Long>{
    VencimientodePuntos busqueda(Date fecha) throws Exception;
}
