package com.example.tp.services;

import com.example.tp.entitiesModelo.VencimientodePuntos;
import com.example.tp.repositorios.BaseRepository;
import com.example.tp.repositorios.VencimientodePuntosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VenPunSerImpl extends BaseServiceImpl<VencimientodePuntos, Long> implements VencdePuntosService{

    public VenPunSerImpl(BaseRepository<VencimientodePuntos, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private VencimientodePuntosRepository vencimiento;

    @Override
    public VencimientodePuntos busqueda(Date fecha) throws Exception {
        try {
            VencimientodePuntos venci= vencimiento.busqueda(fecha);
            return venci;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
