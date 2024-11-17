package com.alura.literalura.model;

import java.time.LocalDate;

public class Autor {
    private String nombreAutor;
    private int anoDeNacimientoAutor;
    private int anoDeFallecimientoAutor;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.nombreAutor = datosAutor.nombre();
        this.anoDeNacimientoAutor = datosAutor.fechaDeNacimiento();
        this.anoDeFallecimientoAutor = datosAutor.fechaDeFallecimiento();
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

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombreAutor + '\'' +
                ", fechaDeNacimiento=" + anoDeNacimientoAutor +
                ", fechaDeFallecimiento=" + anoDeFallecimientoAutor +
                '}';
    }
}
