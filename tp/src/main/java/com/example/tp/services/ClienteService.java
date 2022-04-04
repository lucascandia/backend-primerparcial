package com.example.tp.services;

import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.entitiesModelo.Cliente;

import java.util.List;

// Se declara todos los metodos que vamos a utilizar para la query ya que son metodos
public interface ClienteService extends BaseService<Cliente, Long>{
    List<Cliente> search(String nombre, String apellido, String cumple) throws Exception;
    List<Cliente> diasVencer(int dias) throws Exception;
}
