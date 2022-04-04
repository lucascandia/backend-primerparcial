package com.example.tp.services;

import com.example.tp.entitiesModelo.ConceptosdePuntos;

import java.util.List;

public interface ConceptodePuntosService extends BaseService<ConceptosdePuntos, Long>{
    ConceptosdePuntos puntosRequerido(String concepto) throws Exception;
}
