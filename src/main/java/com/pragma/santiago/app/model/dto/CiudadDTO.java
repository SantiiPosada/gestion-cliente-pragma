package com.pragma.santiago.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDTO  {

    @NotBlank
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

}