package com.example.tp.services;

import com.example.tp.entitiesModelo.ConceptosdePuntos;
import com.example.tp.repositorios.BaseRepository;
import com.example.tp.repositorios.ConceptosdePuntosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptodePuntosServiceImpl extends BaseServiceImpl<ConceptosdePuntos, Long> implements ConceptodePuntosService {
    //Para acceder al repositorio especifico de que necesitemos
    @Autowired
    private ConceptosdePuntosRepository conceptosdePuntosRepository;

    // Para acceder al repositorio general
    public ConceptodePuntosServiceImpl(BaseRepository<ConceptosdePuntos, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public ConceptosdePuntos puntosRequerido(String concepto) throws Exception {
        try {
            ConceptosdePuntos conc= conceptosdePuntosRepository.puntosRequerido(concepto);
            return conc;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
