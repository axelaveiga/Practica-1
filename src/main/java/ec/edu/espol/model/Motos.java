/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Scanner;


/**
 *
 * @author Josue Vera
 */
public class Motos extends Vehiculo {

    public Motos(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
    }
    public static void DatosMoto(Scanner sc){
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa =sc.next();
        Boolean op=Vehiculo.ComprobarPlaca("Vehiculos.txt",placa);
        while(op==true){
            System.out.println("Placa ya registrada en el sistema, por favor ingrese otra: ");
            String placa_n=sc.next();
            placa=placa.replaceAll(placa,placa_n);
            op=Vehiculo.ComprobarPlaca("Vehiculos.txt",placa);
        }
        System.out.println("Ingrese la marca del marca: ");
        String marca= sc.next();
        System.out.println("Ingrese el modelo del modelo: ");
        String modelo= sc.next();
        System.out.println("Ingrese el tipo de motor que tiene el vehiculo: ");
        String motor=sc.next();
        System.out.println("Ingrese el año del vehiculo: ");
        int año= sc.nextInt();
        System.out.println("Ingrese el kilometraje del vehiculo: ");
        double recorrido=sc.nextDouble();
        System.out.println("Ingrese el color del vehiculo: ");
        String color=sc.next();
        System.out.println("Ingrese el tipo de combustible que usa el vehiculo: ");
        String combustible=sc.next();
        System.out.println("Ingrese el precio de su vehiculo: ");
        double precio= sc.nextDouble();
        Vehiculo moto= new Motos(placa,marca,modelo,motor,año,recorrido,color,combustible,precio);
        moto.saveFile("Vehiculos.txt");
        moto.saveFile("Motos.txt");
    }

    }
    
  
