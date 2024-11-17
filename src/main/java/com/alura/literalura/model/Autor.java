package com.alura.literalura.model;

import java.time.LocalDate;

public class Autor {
    private String nombreAutor;
    private LocalDate fechaDeNacimientoAutor;
    private LocalDate fechaDeFallecimientoAutor;

    public Autor() {}

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public LocalDate getFechaDeNacimientoAutor() {
        return fechaDeNacimientoAutor;
    }

    public void setFechaDeNacimientoAutor(LocalDate fechaDeNacimientoAutor) {
        this.fechaDeNacimientoAutor = fechaDeNacimientoAutor;
    }

    public LocalDate getFechaDeFallecimientoAutor() {
        return fechaDeFallecimientoAutor;
    }

    public void setFechaDeFallecimientoAutor(LocalDate fechaDeFallecimientoAutor) {
        this.fechaDeFallecimientoAutor = fechaDeFallecimientoAutor;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombreAutor + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimientoAutor +
                ", fechaDeFallecimiento=" + fechaDeFallecimientoAutor +
                '}';
    }
}
