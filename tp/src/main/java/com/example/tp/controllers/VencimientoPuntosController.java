package com.example.tp.controllers;

import com.example.tp.entitiesModelo.VencimientodePuntos;
import com.example.tp.services.VenPunSerImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/puntos/vencimiento")
public class VencimientoPuntosController extends BaseControllerImpl<VencimientodePuntos, VenPunSerImpl>{

    @GetMapping("/rango")
    public ResponseEntity<?> search(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fecha){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busqueda(fecha));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
