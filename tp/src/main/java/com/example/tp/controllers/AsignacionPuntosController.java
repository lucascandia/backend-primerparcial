package com.example.tp.controllers;

import com.example.tp.entitiesModelo.AsignaciondePuntos;
import com.example.tp.services.AsigPuntSerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/puntos/asignacion")
public class AsignacionPuntosController extends BaseControllerImpl<AsignaciondePuntos, AsigPuntSerImpl>{

    @GetMapping("/calculo")
    public ResponseEntity<?> search(@RequestParam int monto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.calculo(monto));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
