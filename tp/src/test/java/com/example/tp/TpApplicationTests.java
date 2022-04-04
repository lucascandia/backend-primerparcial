package com.example.tp;

import com.example.tp.controllers.BolsaPuntoController;
import com.example.tp.entitiesModelo.BolsadePuntos;
import com.example.tp.services.BolPunServImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class TpApplicationTests {

    @Test
    public void testHomeController() throws Exception {/*
        BolPunServImpl bol= new BolPunServImpl();
        BolsadePuntos bolsadeController= new BolsadePuntos();
        Date date = java.sql.Date.valueOf("2020-07-20");
        bolsadeController.setFecha_caducidad(date);
        bolsadeController.setMonto_operacion(300000);
        bolsadeController.setId_cliente(1);
        BolsadePuntos result = bol.guardar(bolsadeController);
        assertEquals(result, "Hello World!");*/
    }

}
