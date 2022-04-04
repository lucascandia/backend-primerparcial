package com.example.tp.repositorios;

import com.example.tp.entitiesModelo.ConceptosdePuntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ConceptosdePuntosRepository extends BaseRepository<ConceptosdePuntos, Long> {
    @Query(value= "SELECT co FROM ConceptosdePuntos co WHERE co.descripcion LIKE %:concepto% ")
    ConceptosdePuntos puntosRequerido(@Param("concepto") String concepto);
}
