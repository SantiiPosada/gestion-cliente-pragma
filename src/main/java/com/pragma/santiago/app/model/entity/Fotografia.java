package com.pragma.santiago.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "fotografia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fotografia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "base64")
    private String base64;

    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;


}