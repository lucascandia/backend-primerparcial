package com.example.tp.entitiesModelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="vencimiento_puntos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VencimientodePuntos extends Base{
    @Column(name= "fecha_inicio")
    @Temporal(TemporalType.DATE)
    @Basic(optional= false)
    private Date fecha_inicio;

    @Column(name= "fecha_fin")
    @Temporal(TemporalType.DATE)
    @Basic(optional= false)
    private Date fecha_fin;

    @Column(name= "dias_duracion")
    @Basic(optional= false)
    private int dias_duracion;
}