package com.REMG.x00037119;

import java.util.ArrayList;

public class Empleado {

    protected String nombre;
    protected String puesto;
    protected List<Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        List<documento> documentos = new ArrayList<Documento>();
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
                int pos = documentos.indexOf(doc);
                documentos.remove(pos );
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
