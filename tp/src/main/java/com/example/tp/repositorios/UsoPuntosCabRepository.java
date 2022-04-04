package com.example.tp.repositorios;


import com.example.tp.entitiesModelo.UsodePuntosCabec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsoPuntosCabRepository extends BaseRepository<UsodePuntosCabec, Long>{
    @Query(value= "SELECT u FROM UsodePuntosCabec u WHERE u.concepto_uso LIKE %:concepto% OR  :fecha = u.fecha OR :idcliente = u.cliente_id")
    List<UsodePuntosCabec> usoPuntos(@Param("concepto") String concepto, @Param("fecha") Date fecha, @Param("idcliente") int idcliente);
}

