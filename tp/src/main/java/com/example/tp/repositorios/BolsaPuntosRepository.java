package com.example.tp.repositorios;

import com.example.tp.entitiesModelo.BolsadePuntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BolsaPuntosRepository extends BaseRepository<BolsadePuntos, Long>{

    @Query(value= "SELECT b FROM BolsadePuntos b WHERE b.id_cliente=:id OR b.saldo_puntos>=:ini AND b.saldo_puntos<= :fin")
    List<BolsadePuntos> busq(@Param("id") int id, @Param("ini") int ini,  @Param("fin") int fin);

    @Query(value= "SELECT b FROM BolsadePuntos b WHERE  b.fecha_caducidad= :fecha")
    List<BolsadePuntos> diasVencer(@Param("fecha") Date fecha);
}
