package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("translators") List<String> traductores,
        @JsonAlias("subjects") List<String> temas,
        @JsonAlias("bookshelves") List<String> estanterias,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("copyright") boolean derechosAutor,
        @JsonAlias("download_count") Long cantidadDescargas
) {
}
