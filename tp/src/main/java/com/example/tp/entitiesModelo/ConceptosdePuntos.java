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
@Table(name = "puntos_utilizados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ConceptosdePuntos extends Base{
    @Column(name = "descripcion")
    @Basic(optional= false)
    private String descripcion;

    @Column(name = "puntos_requerido")
    @Basic(optional= false)
    private int puntos_requerido;
}
