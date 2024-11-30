package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
//@Table(name="libro",uniqueConstraints = {
//        @UniqueConstraint(columnNames = "titulo")
//})
@Table(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long identifyer;
    @Column(unique = true)
    private String titulo;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Autor> autores;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Traductor> traductores;
    private List<String> temas;
    private List<String> estanterias;
    private List<String> idiomas;
    private boolean derechosDeAutor;
    private Long cantidadDeDescargas;

    public Libro() {}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores()
                .stream().map(a->new Autor(a))
                .collect(Collectors.toList());
//        this.traductores = datosLibro.traductores();
        this.traductores = datosLibro.traductores()
                .stream().map(t->new Traductor(t))
                .collect(Collectors.toList());
        this.temas = datosLibro.temas();
        this.estanterias = datosLibro.estanterias();
        this.idiomas = datosLibro.idiomas();
        this.derechosDeAutor = datosLibro.derechosAutor();
        this.cantidadDeDescargas = datosLibro.cantidadDescargas();
        this.identifyer=datosLibro.identifyer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getIdentifyer() {
        return identifyer;
    }

    public void setIdentifyer(Long identifyer) {
        this.identifyer = identifyer;
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
        return "Libro{\n" +
                " \"titulo\": \"" + titulo + "\",\n"
                +" \"ID de la api\": \"" + identifyer + "\",\n"
                + " \"autores\": " + autores + ",\n"
                + " \"traductores\": " + traductores + ",\n" +
                " \"temas\": " + temas + ",\n"
                + " \"estanterias\": " + estanterias + ",\n"
                + " \"idiomas\": " + idiomas + ",\n"
                + " \"derechosDeAutor\": " + derechosDeAutor
                + ",\n" + " \"cantidadDeDescargas\": " + cantidadDeDescargas
                + "\n" + "}";
    }
}
