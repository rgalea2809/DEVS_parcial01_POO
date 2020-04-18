package com.REMG.x00037119;
// PARCIAL 01 POO CICLO 01/ 2020
//Gabriela Solorzano 001815 | Rodrigo Mejia 00037119
import javax.swing.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
        boolean on = true;
        Empresa empresa = new Empresa(JOptionPane.showInputDialog(null, "Ingrese el nombre de su empresa: "));

        do {
            switch (printMenu(empresa)){
                case 1:
                    Empleado toContract =  contratar();
                    if (toContract == null){
                        break;
                    }
                    empresa.addEmpleado(toContract);
                    JOptionPane.showMessageDialog(null, "Empleado ingresado exitosamente.");
                    break;
                case 2:
                    String toFire = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado a despedir: ");
                    try{ empresa.quitEmpleado(toFire);}
                    catch (NotAnEmployeeException ex){
                        System.out.println(ex.getMessage());
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        break;
                   }
                    JOptionPane.showMessageDialog(null, "Empleado eliminado de base de datos exitosamente!");
                    break;
                case 3:
                    String listaEmpleados = planillaToString(empresa);
                    JOptionPane.showMessageDialog(null, listaEmpleados);
                    break;
                case 4:
                    double salary =0;
                    String employeeName = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado: ");
                    try{salary = calcSalary(employeeName, empresa.getPlanilla());}
                    catch (NotAnEmployeeException ex){
                        System.out.println(ex.getMessage());
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "El salario del empleado "+ employeeName
                            + " luego de aplicar descuentos es de: \n $"+ salary);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Adios...");
                    on = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error; Intentelo de nuevo!");
            }

        }while(on);


    }

    public static int printMenu(Empresa empresa){
        int x=0;
        try {
            x = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Bienvenido al menu de " + empresa.getNombre() + ". " +
                            "\nIngrese el numero de la opcion que desea realizar\n1- Agregar Empleado a planilla." +
                            "\n2- Despedir Empleado.\n3- Ver lista de Empleados.\n4- Calcular Sueldo de Empleado.\n" +
                            "5- Mostrar Total de impuestos retenidos.\n6- SALIR DEL SISTEMA"));
            if(x <1 || x> 6){
                throw new IntegerOutOfBoundsException("Ingreso un numero Invalido!");
            }

        }
        catch (IntegerOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
        catch (Exception ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Ocurrió un error! Intentelo de nuevo.");

            return 0;
        }
        return x;
    }

    public static Empleado contratar(){
        int x =0;
        try {
            x = Integer.parseInt(JOptionPane.showInputDialog(null, "Que tipo de Empleado desea ingresar al sistema?. " +
                    "\nIngrese el numero de la opcion que desea realizar\n1- Contratar servicio profesional." +
                    "\n2- Contratar Plaza Fija."));
            if(x <1 || x> 2){
                throw new IntegerOutOfBoundsException("Ingreso un numero Invalido!");
            }
        }
        catch (IntegerOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ocurrió un error! Intentelo de nuevo.");
            return null;
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado: ");
        String puesto = JOptionPane.showInputDialog(null, "Ingrese el Puesto del empleado: ");
        double salario =0;
        try{
            salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el Salario del empleado: "));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el salario, intentelo de nuevo!");
            return null;
        }

        Empleado empleado = null;
        switch (x) {
            case 1:
                int meses = 0;
                try {
                    meses = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la cantidad de meses a contratar el servicio profesional: "));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar la cantidad de meses, intentelo de nuevo!");
                    return null;
                }
                empleado = new ServicioProfesional(nombre, puesto, salario, meses);
                break;
            case 2:
                int extension = 0;
                try {
                    extension = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese la extension (Numero telefonico) del nuevo empleado: "));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar el numero telefonico, intentelo de nuevo!");
                    return null;
                }
                empleado = new PlazaFIja(nombre, puesto, salario, extension);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error, intentelo de nuevo.");
        }
        return empleado;
    }

    public static String planillaToString(Empresa empresa){
        List<Empleado> aux = empresa.getPlanilla();

        AtomicReference<String> listaConcat = new AtomicReference<>("LISTA DE EMPLEADOS: \n");

        aux.forEach(empleado -> {
            if(empleado instanceof PlazaFIja){
                listaConcat.set(listaConcat + "NOMBRE: "+ empleado.getNombre() + ". PUESTO: "+ empleado.getPuesto()+
                        ". SALARIO: "+ empleado.getSalario()+ ". EXTENSION: "+ ((PlazaFIja) empleado).getExtension()+
                        ". (EMPLEADO FIJO)\n");
            }
            else if (empleado instanceof ServicioProfesional){
                listaConcat.set(listaConcat + "NOMBRE: "+ empleado.getNombre() + ". PUESTO: "+ empleado.getPuesto()+
                        ". SALARIO: "+ empleado.getSalario()+ ". DURACION DE CONTRATO: "+ ((ServicioProfesional) empleado).getMeses()+
                        ". (SERVICIO PROFESIONAL)\n");
            }
        });
        return listaConcat.get();
    }

    public static double calcSalary(String name, List<Empleado> planilla) throws NotAnEmployeeException {
        AtomicReference<Double> salary= new AtomicReference<>((double) 0);
        AtomicInteger cont = new AtomicInteger(0);
        planilla.forEach(e-> {
                    if( e.getNombre().equals(name) ){
                        salary.set(CalculadoraImpuestos.calcularPago(e));
                        cont.set(1);
                    }
                }
        );
        int aux = cont.get();

        if(aux != 1){
            throw new NotAnEmployeeException("El nombre del empleado no se encuentra en la base de datos!");
        }

        return salary.get();
    }

}


