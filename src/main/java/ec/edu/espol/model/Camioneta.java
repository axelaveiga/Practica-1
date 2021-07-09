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
public class Camioneta extends Vehiculo {

    protected String vidrios;
    protected String transmision;
    protected String traccion;

    public Camioneta(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision, String traccion) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;

    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public static void DatosCamioneta(Scanner sc) {
        System.out.println("Ingrese la placa del vehiculo: ");
        String placa = sc.next();
        Boolean op = Vehiculo.ComprobarPlaca("Vehiculos.txt", placa);
        while (op == true) {
            System.out.println("Placa ya registrada en el sistema, por favor ingrese otra: ");
            String placa_n = sc.next();
            placa = placa.replaceAll(placa, placa_n);
            op = Vehiculo.ComprobarPlaca("Vehiculos.txt", placa);
        }
        System.out.println("Ingrese la marca del vehiculo: ");
        String marca = sc.next();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo = sc.next();
        System.out.println("Ingrese el tipo de motor que tiene el vehiculo: ");
        String motor = sc.next();
        System.out.println("Ingrese el año del vehiculo: ");
        int año = sc.nextInt();
        System.out.println("Ingrese el kilometraje del vehiculo: ");
        double recorrido = sc.nextDouble();
        System.out.println("Ingrese el color del vehiculo: ");
        String color = sc.next();
        System.out.println("Ingrese el tipo de combustible que usa el vehiculo: ");
        String combustible = sc.next();
        System.out.println("Ingrese el precio de su vehiculo: ");
        double precio = sc.nextDouble();
        System.out.println("Ingrese la transmision del vehiculo: ");
        String transmision = sc.next();
        System.out.println("Ingrese que tipos de vidrio tine su vehiculo: ");
        String vidrios = sc.next();
        System.out.println("Ingrese la traccion del vehiculo: ");
        String traccion = sc.next();
        Vehiculo camioneta = new Camioneta(vidrios, placa, marca, modelo, motor, año, recorrido, color, combustible, precio, transmision, traccion);
        camioneta.saveFile("Vehiculos.txt");
        camioneta.saveFile("Camionetas.txt");
    }
}
