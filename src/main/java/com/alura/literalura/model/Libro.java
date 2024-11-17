package com.alura.literalura.model;

import java.util.List;


public class Libro {
    private int id;
    private int apiId;
    private String titulo;
    private List<Autor> autores;
    private List<Traductor> traductores;
    private List<String> temas;
    private List<String> estanterias;
    private List<String> idiomas;
    private boolean derechosDeAutor;
    private Long cantidadDeDescargas;

    public Libro() {}

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Traductor> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Traductor> traductores) {
        this.traductores = traductores;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public List<String> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(List<String> estanterias) {
        this.estanterias = estanterias;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public boolean isDerechosDeAutor() {
        return derechosDeAutor;
    }

    public void setDerechosDeAutor(boolean derechosDeAutor) {
        this.derechosDeAutor = derechosDeAutor;
    }

    public Long getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(Long cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "apiId=" + apiId +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", traductores=" + traductores +
                ", temas=" + temas +
                ", estanterias=" + estanterias +
                ", idiomas=" + idiomas +
                ", derechosDeAutor=" + derechosDeAutor +
                ", cantidadDeDescargas=" + cantidadDeDescargas +
                '}';
    }
}
