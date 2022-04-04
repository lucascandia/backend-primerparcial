package com.example.tp.entitiesModelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="usode_puntos_cabec")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsodePuntosCabec extends Base{
    // Es persist porque cuando se borre un UsodePuntosCabec el cliente no se debe borrar de la misma
    @Column(name= "cliente_id")
    @Basic(optional= false)
    private int cliente_id;

    @Column(name= "puntaje_utilizado")
    private int puntaje_utilizado;
    //del dia
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "concepto_uso")
    @Basic(optional= false)
    private String concepto_uso;

}
