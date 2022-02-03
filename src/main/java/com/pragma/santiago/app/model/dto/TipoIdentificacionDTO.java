package com.pragma.santiago.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoIdentificacionDTO {

    @NotBlank
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;


}