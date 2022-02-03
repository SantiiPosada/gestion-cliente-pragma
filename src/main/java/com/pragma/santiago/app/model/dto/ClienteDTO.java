package com.pragma.santiago.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteDTO {



    private Integer id;


    private String nombre;


    private String apellido;


    private Integer edad;


    private Long identificacion;


    private String correo;


    private CiudadDTO Ciudad;


    private TipoIdentificacionDTO TipoIdentificacion;


}