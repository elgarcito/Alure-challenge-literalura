package com.alura.literalura.model;

import java.time.LocalDate;

public class Traductor {
    private String nombreTraductor;
    private int fechaDeNacimientoTraductor;
    private int fechaDeFallecimientoTraductor;

    public Traductor() {}

    public Traductor(DatosTraductor datosTraductor) {
        this.nombreTraductor = datosTraductor.nombreTraductor();
        this.fechaDeNacimientoTraductor = datosTraductor.fechaDeNacimientoTraductor();
        this.fechaDeFallecimientoTraductor = datosTraductor.fechaDeFallecimientoTraductor();
    }

    public String getNombreTraductor() {
        return nombreTraductor;
    }

    public void setNombreTraductor(String nombreTraductor) {
        this.nombreTraductor = nombreTraductor;
    }

    public int getFechaDeNacimientoTraductor() {
        return fechaDeNacimientoTraductor;
    }

    public void setFechaDeNacimientoTraductor(int fechaDeNacimientoTraductor) {
        this.fechaDeNacimientoTraductor = fechaDeNacimientoTraductor;
    }

    public int getFechaDeFallecimientoTraductor() {
        return fechaDeFallecimientoTraductor;
    }

    public void setFechaDeFallecimientoTraductor(int fechaDeFallecimientoTraductor) {
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
