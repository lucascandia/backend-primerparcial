package com.example.tp.services;

import com.example.tp.entitiesModelo.Base;

import java.io.Serializable;
import java.util.List;
// Ver si no tiene que llevar el @Service
public interface BaseService <E extends Base, ID extends Serializable>{
    //Trae toda las lista de los clientes( o entidades) en nuestra base de datos
    public List findAll() throws Exception;

    // Obtener un cliente o entidad de acuerdo a su id
    public E findById(ID id) throws Exception;

    //Crea una nueva entidad
    public E save(E entity) throws Exception;

    // Actualiza la entidad
    public E update(ID id, E entity) throws Exception;

    // Elimina una entidad o registro de la base de datos
    public boolean delete(ID id) throws Exception;
}
