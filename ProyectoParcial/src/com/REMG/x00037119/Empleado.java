package com.REMG.x00037119;

import java.util.List;

abstract class Empleado {

    protected String nombre;
    protected String puesto;
    protected List<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento (Documento doc){
        documentos.add(doc);
    }

    public void removeDocumento (String nombre){

        documentos.forEach(doc -> {
            if( doc.getNombre().equals(nombre) ){
                documentos.remove(doc);
            }
        }
        );
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
