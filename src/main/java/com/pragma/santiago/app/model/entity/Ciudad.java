package com.pragma.santiago.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ciudad")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45,unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 254)
    private String descripcion;
}