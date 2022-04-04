package com.example.tp.services;


import com.example.tp.entitiesModelo.Detalle;
import com.example.tp.repositorios.BaseRepository;
import com.example.tp.repositorios.DetalleRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServImpl extends BaseServiceImpl<Detalle, Long> implements DetalleServ{
    public DetalleServImpl(BaseRepository<Detalle, Long> baseRepository) {
        super(baseRepository);
    }


}
