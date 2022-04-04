package com.example.tp.repositorios;

import com.example.tp.entitiesModelo.AsignaciondePuntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AsignaciondePuntosRepository extends BaseRepository<AsignaciondePuntos, Long> {
    @Query(value= "SELECT a FROM AsignaciondePuntos a WHERE :monto>= a.limite_inferior AND :monto<= a.limite_superior")
   AsignaciondePuntos calculo(@Param("monto") int monto);
}
