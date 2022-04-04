package com.example.tp.entitiesModelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="bolsa_puntos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BolsadePuntos extends Base{
    //Se carga en el 8.a
    @Column(name = "fecha_asignacion", length = 10)
    @Temporal(TemporalType.DATE)
    @Basic(optional= false)
    private Date fecha_asignacion;

    // La fecha de caducida se saca con respecto a los dias de duración de los puntajes
    @Column(name = "fecha_caducidad", length = 10)
    @Temporal(TemporalType.DATE)
    private Date fecha_caducidad;

    // Se saca con el calculo del modelo asignacion
    @Column(name = "puntaje_asignado")
    private int puntaje_asignado;

    // Al iniciar es cero
    @Column(name = "puntaje_utilizado")
    private int puntaje_utilizado;

    @Column(name = "saldo_puntos")
    private int saldo_puntos;

    @Column(name = "monto_operacion")
    @Basic(optional= false)
    private int monto_operacion;

    @Column(name = "id_cliente")
    @Basic(optional= false)
    private int id_cliente;
}
