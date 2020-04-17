package com.REMG.x00037119;

public class CalculadoraImpuestos {
    private double totalRenta;
    private double totalISSS;
    private double totalAFP;

    private CalculadoraImpuestos(){ }

    public static double calcularPago(Empleado empleado){
        double total=0;
        double salario= empleado.getSalario();

        if(empleado instanceof ServicioProfesional){
            double renta1 = (salario * 0.1);
            total= (salario - renta1);
        }
        else if(empleado instanceof PlazaFIja){
            double AFP = (0.0625 * salario);
            double ISSS = (0.03 * salario);
            double restante = (salario - AFP - ISSS);




        }
        return total;
    }

    public static String mostrarTotales (){

        return "asd";
    }




}
