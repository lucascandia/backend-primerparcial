package com.example.tp.controllers;


import com.example.tp.entitiesModelo.UsodePuntosCabec;
import com.example.tp.services.UsoPuntoSerImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping(path="api/puntos/uso")

public class UsoPuntosControler extends BaseControllerImpl<UsodePuntosCabec, UsoPuntoSerImpl>{

    @PostMapping("/gasto")
    public ResponseEntity<?> consumo(@RequestBody UsodePuntosCabec entity){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(servicio.consumo(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intentar de nuevo.\"}");
        }
    }

    @GetMapping("/historial")
    public ResponseEntity<?> busqueda(@RequestParam String concepto, @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fecha, @RequestParam int idcliente){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.usoPuntos(concepto, fecha, idcliente));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
