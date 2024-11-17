package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTraductor(
        @JsonAlias("name") String nombreTraductor,
        @JsonAlias("birth_year") int fechaDeNacimientoTraductor,
        @JsonAlias("death_year") int fechaDeFallecimientoTraductor
) {
}
