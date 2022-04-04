package com.example.tp.controllers;

import com.example.tp.entitiesModelo.ConceptosdePuntos;
import com.example.tp.services.ConceptodePuntosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/puntos/concepto")
public class ConceptosdePuntosController extends BaseControllerImpl<ConceptosdePuntos, ConceptodePuntosServiceImpl>{

    @GetMapping("/requerido")
    public ResponseEntity<?> search(@RequestParam String concepto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.puntosRequerido(concepto));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
