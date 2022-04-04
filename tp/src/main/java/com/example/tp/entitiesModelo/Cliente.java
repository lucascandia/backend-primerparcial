package com.example.tp.entitiesModelo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Audited
public class Cliente extends Base{

    @Column(name= "nombre", length = 50)
    @Basic(optional= false)
    private String nombre;

    @Column(name= "apellido", length = 50)
    @Basic(optional= false)
    private String apellido;

    @Column(name= "numero_telefono")
    @Basic(optional= false)
    private String numerotelefono;

    @Column(name= "tipo_documento", length = 50)
    @Basic(optional= false)
    private String tipo_documento;

    @Column(name= "nacionalidad", length = 50)
    @Basic(optional= false)
    private String nacionalidad;

    @Column(name= "email", length = 50)
    @Basic(optional= false)
    private String email;

    @Column(name= "fecha_nacimiento", length = 10)
    @Basic(optional= false)
    private String fecha_nacimiento;

}
