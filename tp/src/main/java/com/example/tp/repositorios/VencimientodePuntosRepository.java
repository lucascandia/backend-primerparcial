package com.example.tp.repositorios;

import com.example.tp.entitiesModelo.VencimientodePuntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface VencimientodePuntosRepository extends BaseRepository<VencimientodePuntos, Long>{
    @Query(value= "SELECT v FROM VencimientodePuntos v WHERE :filtro >= v.fecha_inicio AND :filtro <= v.fecha_fin")
    VencimientodePuntos busqueda(@Param("filtro") Date filtro);

}
