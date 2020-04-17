package com.REMG.x00037119;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Empresa {

    private String nombre;
    public List<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<Empleado>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getPlanilla() {
        return planilla;
    }

    public void addEmpleado (Empleado employ){
        planilla.add(employ);
    }

    public void quitEmpleado (String nombre) throws NotAnEmployeeException {
        AtomicInteger cont = new AtomicInteger(0);
        planilla.forEach(empleado-> {
                    if( empleado.getNombre().equals(nombre) ){
                        planilla.remove(empleado);
                        cont.set(1);
                    }
                }
        );
        int aux = cont.get();

        if(aux != 1){
            throw new NotAnEmployeeException("El nombre del empleado no se encuentra en la base de datos!");
        }

    }

}
