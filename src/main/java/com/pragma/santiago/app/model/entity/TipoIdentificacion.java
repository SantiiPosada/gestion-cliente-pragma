package com.pragma.santiago.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "tipo_identificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoIdentificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45,unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 254)
    private String descripcion;


}