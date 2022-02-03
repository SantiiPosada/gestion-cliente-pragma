package com.pragma.santiago.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "edad", nullable = false,length = 3)
    private Integer edad;

    @Column(name = "identificacion", nullable = false, length = 20,unique = true)
    private Long identificacion;

    @Column(name = "correo", nullable = false, length = 100,unique = true)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad Ciudad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_identificacion")
    private TipoIdentificacion TipoIdentificacion;


}