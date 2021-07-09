/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ProyectoPOO;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vendedor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Axel
 * @author Josue
 * @author Jose
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US); 
        int opcion = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("-- Menu de opciones --");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.println("Ingrese una de las opciones: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int opcionv = 0;
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("-- Menu Vendedor --");
                        System.out.println("1. Registrar un nuevo vendedor");
                        System.out.println("2. Ingresar un nuevo vehiculo");
                        System.out.println("3. Aceptar oferta");
                        System.out.println("4. Regresar");
                        System.out.println("Ingrese una opcion: ");
                        opcionv = sc.nextInt();
                        switch (opcionv) {
                            case 1:
                                Vendedor.RegistarVendedor(sc);
                                break;
                            case 2:
                                Vendedor.RegistrarVehiculo(sc);
                                break;
                            case 3:

                                break;
                            case 4:
                                break;
                        }
                    } while (opcionv != 4);
                    break;
                case 2:
                    int opcionc = 0;
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("-- Menu Comprador --");
                        System.out.println("1. Registrar un nuevo comprador");
                        System.out.println("2. Ofertar por un vehiculo");
                        System.out.println("3. Regresar");
                        System.out.println("Ingrese opcion: ");
                        opcionc = sc.nextInt();
                        switch (opcionc) {
                            case 1:
                                Comprador.RegistarComprador(sc);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    } while (opcionc != 3);
                    break;
                case 3:
                    System.out.println("Gracias por su atención");
                    break;
            }
        } while (opcion != 3);

    }
}
