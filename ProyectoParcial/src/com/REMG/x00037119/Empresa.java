package com.REMG.x00037119;

import java.util.List;

public class Empresa {

    private String nombre;
    private List<Empleado> plantilla;

    public Empresa(String nombre, String plantilla) {
        this.nombre = nombre;
        this.plantilla = plantilla
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlantilla() {
        return plantilla;
    }




}
