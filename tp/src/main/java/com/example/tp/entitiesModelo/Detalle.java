package com.example.tp.entitiesModelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="detalle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Detalle extends Base{

    @Column(name= "id_cabecera")
    private Long id_cabecera;

    @Column(name= "puntaje_utilizado")
    private int puntaje_utilizado;

    // Si en un detalle ya utilizo tod0 su punto entonces en la bolsa de puntos tambien se debe borrar
    @Column(name= "id_bolsa")
    private Long id_bolsa;

}
