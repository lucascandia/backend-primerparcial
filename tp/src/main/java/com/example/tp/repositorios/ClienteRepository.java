package com.example.tp.repositorios;

import com.example.tp.entitiesModelo.Cliente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
    //Query con JPQL: La sintaxis es similar a SQL, pero en lugar de trabajar con los nombres
    // de las tablas y campos, trabajamos con los nombres de las entidades y atributos definidos en la POO
    @Query(value= "SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.fecha_nacimiento LIKE %:cumple%")
    List<Cliente> search(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("cumple") String cumple);


}
/*
    //Query nativa (con SQL)
    //En este caso SQL trabaja directamente con las tablas de nuestra base de datos,
    // por lo que deberemos trabajar conlos nombre de las tablas y campos o columnas que asignamos en nuestro modelo.
    @Query(
            value= "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% OR cliente.fecha_nacimiento LIKE %:filtro%",
            nativeQuery= true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);*/