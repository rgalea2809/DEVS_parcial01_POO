package com.REMG.x00037119;

public class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos(){ }

    public static double calcularPago(Empleado empleado){
        double total=0;
        double salario= empleado.getSalario();

         if(empleado instanceof ServicioProfesional){
            double renta1 = (salario * 0.1);
             totalRenta += renta1;
            total= (salario - renta1);
            }
         else if(empleado instanceof PlazaFIja) {
            double renta2 = 0;
            double AFP = (0.0625 * salario);
            double ISSS = (0.03 * salario);
            double restante = (salario - AFP - ISSS);

            if (restante >= 0.01 && restante <= 472.00) {
                renta2 = 0;
            } else if (restante >= 472.01 && restante <= 895.24) {
                renta2 = (0.1 * (restante - 472) + 17.67);
            } else if (restante >= 895.25 && restante <= 2037.10) {
                renta2 = (0.2 * (restante - 895.24) + 60);
            } else if (restante >= 2038.11) {
                renta2 = (0.3 * (restante - 2038.10) + 288.57);
            }
            totalRenta+= renta2;
            totalAFP += AFP;
            totalISSS += ISSS;

            total= (restante - renta2);
        }
        return total;
    }

    public static String mostrarTotales (){

        return "TOTALES ACUMULADOS: \na) AFP: $"+ totalAFP+ ". \nb) ISS: $ "+totalISSS+ ". \nc)Renta: $"+totalRenta+".";
    }




}
