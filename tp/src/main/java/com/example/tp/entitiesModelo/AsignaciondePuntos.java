package com.example.tp.entitiesModelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="asignacion_puntos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsignaciondePuntos extends Base {
    @Column(name = "limite_inferior", length = 50)
    @Basic(optional= false)
    private int limite_inferior;

    @Column(name = "limite_superior", length = 50)
    @Basic(optional= false)
    private int limite_superior;

    @Column(name = "monto_equi")
    @Basic(optional= false)
    private int monto_equi;

}
