package com.example.tp.controllers;

import com.example.tp.entitiesModelo.Cliente;
import com.example.tp.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping(path="api/puntos/cliente")

public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    @GetMapping("/busqueda")
    public ResponseEntity<?> search(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String cumple){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(nombre, apellido, cumple));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/vencer")
    public ResponseEntity<?> diasVencer(@RequestParam int dias){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.diasVencer(dias));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
