package com.example.tp.services;

import com.example.tp.entitiesModelo.AsignaciondePuntos;
import com.example.tp.repositorios.AsignaciondePuntosRepository;
import com.example.tp.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsigPuntSerImpl extends BaseServiceImpl<AsignaciondePuntos, Long> implements AsignacionPuntosService{
    public AsigPuntSerImpl(BaseRepository<AsignaciondePuntos, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private AsignaciondePuntosRepository asig;

    @Override
    public int calculo(int monto) throws Exception {
        try {
            AsignaciondePuntos puntos= asig.calculo(monto);
            return puntos.getMonto_equi();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
