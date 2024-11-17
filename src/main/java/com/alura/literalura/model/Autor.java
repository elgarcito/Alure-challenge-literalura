package com.alura.literalura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreAutor;
    private int anoDeNacimientoAutor;
    private int anoDeFallecimientoAutor;
    @ManyToMany
    private List<Libro> librosPorAutor;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.nombreAutor = datosAutor.nombre();
        this.anoDeNacimientoAutor = datosAutor.fechaDeNacimiento();
        this.anoDeFallecimientoAutor = datosAutor.fechaDeFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getAnoDeFallecimientoAutor() {
        return anoDeFallecimientoAutor;
    }

    public void setAnoDeFallecimientoAutor(int anoDeFallecimientoAutor) {
        this.anoDeFallecimientoAutor = anoDeFallecimientoAutor;
    }

    public int getAnoDeNacimientoAutor() {
        return anoDeNacimientoAutor;
    }

    public void setAnoDeNacimientoAutor(int anoDeNacimientoAutor) {
        this.anoDeNacimientoAutor = anoDeNacimientoAutor;
    }

    public List<Libro> getLibrosPorAutor() {
        return librosPorAutor;
    }

    public void setLibrosPorAutor(List<Libro> librosPorAutor) {
        this.librosPorAutor = librosPorAutor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombreAutor + '\'' +
                ", fechaDeNacimiento=" + anoDeNacimientoAutor +
                ", fechaDeFallecimiento=" + anoDeFallecimientoAutor +
                '}';
    }
}
