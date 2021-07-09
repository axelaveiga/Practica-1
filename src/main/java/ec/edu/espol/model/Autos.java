package ec.edu.espol.model;

import java.util.Scanner;

/**
 *
 * @author Axel
 */
public class Autos extends Vehiculo {

    protected String vidrios;
    protected String transmision;

    public Autos(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
        this.transmision = transmision;
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

    public static void DatosAuto(Scanner sc) {
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
        Vehiculo auto = new Autos(vidrios, placa, marca, modelo, motor, año, recorrido, color, combustible, precio, transmision);
        auto.saveFile("Vehiculos.txt");
        auto.saveFile("Autos.txt");
    }
}
