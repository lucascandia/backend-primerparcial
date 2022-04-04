package com.example.tp.controllers;

import com.example.tp.entitiesModelo.Detalle;
import com.example.tp.services.DetalleServImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping(path="api/puntos/detalle")

public class DetalleController extends BaseControllerImpl<Detalle, DetalleServImpl>{
}
