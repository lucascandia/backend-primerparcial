package com.example.tp.services;

import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.entitiesModelo.Cliente;


import java.util.Date;
import java.util.List;

public interface BolsaPuntosService extends BaseService<BolsadePuntos, Long>{
     BolsadePuntos guardar(BolsadePuntos entity) throws Exception;
     List<BolsadePuntos> busq(int id, int ini, int fin) throws Exception;
     List<BolsadePuntos> dias(Date fecha) throws Exception;

}
