package com.example.tp.services;

import com.example.tp.entitiesModelo.AsignaciondePuntos;


public interface AsignacionPuntosService extends BaseService<AsignaciondePuntos, Long>{
    int calculo(int monto) throws Exception;
}
