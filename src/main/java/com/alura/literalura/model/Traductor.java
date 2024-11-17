package com.alura.literalura.model;

import java.time.LocalDate;

public class Traductor {
    private String nombreTraductor;
    private LocalDate fechaDeNacimientoTraductor;
    private LocalDate fechaDeFallecimientoTraductor;

    public Traductor() {}

    public String getNombreTraductor() {
        return nombreTraductor;
    }

    public void setNombreTraductor(String nombreTraductor) {
        this.nombreTraductor = nombreTraductor;
    }

    public LocalDate getFechaDeNacimientoTraductor() {
        return fechaDeNacimientoTraductor;
    }

    public void setFechaDeNacimientoTraductor(LocalDate fechaDeNacimientoTraductor) {
        this.fechaDeNacimientoTraductor = fechaDeNacimientoTraductor;
    }

    public LocalDate getFechaDeFallecimientoTraductor() {
        return fechaDeFallecimientoTraductor;
    }

    public void setFechaDeFallecimientoTraductor(LocalDate fechaDeFallecimientoTraductor) {
        this.fechaDeFallecimientoTraductor = fechaDeFallecimientoTraductor;
    }

    @Override
    public String toString() {
        return "Traductor{" +
                "nombre='" + nombreTraductor + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimientoTraductor +
                ", fechaDeFallecimiento=" + fechaDeFallecimientoTraductor +
                '}';
    }
}
