package com.example.tp.controllers;

import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.services.BolPunServImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping(path="api/puntos/bolsa")
public class BolsaPuntoController extends BaseControllerImpl<BolsadePuntos, BolPunServImpl>{

    @PostMapping("/crear")
    public ResponseEntity<?> guardar(@RequestBody BolsadePuntos entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(servicio.guardar(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentar de nuevo.\"}");
        }
    }

    @GetMapping("/busqueda")
    public ResponseEntity<?> busq(@RequestParam int id, @RequestParam int ini, @RequestParam int fin){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.busq(id, ini, fin));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/fechas")
    public ResponseEntity<?> search(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fecha){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.dias(fecha));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
