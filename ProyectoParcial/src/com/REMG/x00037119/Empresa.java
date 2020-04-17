package com.REMG.x00037119;


import java.util.List;

public class Empresa {

    private String nombre;
    public List<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlantilla() {
        return planilla;
    }

    public void addEmpleado (Empleado employ){
        planilla.add(employ);
    }

    public void quitEmpleado (String nombre){

        planilla.forEach(empleado-> {
                    if( empleado.getNombre().equals(nombre) ){
                        planilla.remove(empleado);
                    }
                }
        );
    }

}
