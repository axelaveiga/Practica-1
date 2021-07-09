/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Josue Vera
 */
public class Comprador extends Persona {

    public Comprador(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }

    public static void RegistarComprador(Scanner sc) {
        System.out.println("Ingrese sus nombres: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese sus Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Ingrese la Organizacion donde trabaja: ");
        String organizacion = sc.nextLine();
        System.out.println("Ingrese su correo electronico: ");
        String correo = sc.next();
        while (Persona.validarEmail(correo) == false) {
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
        }
        boolean estar = Comprador.ComprobarCorreoComprador("ArchivoCompradores.txt", correo);
        while (estar == false) {
            System.out.println("El correo ingresado ya esta registrado, ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
            estar = Comprador.ComprobarCorreoComprador("ArchivoCompradores.txt", correo);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena = sc.next();

        String contrasenaConvertida = Persona.convertirSHA256(contrasena);
        Comprador c = new Comprador(nombre, apellidos, organizacion, correo, contrasenaConvertida);
        c.saveFile("ArchivoCompradores");
    }

    public void saveFile(String nomfile) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true))) {
            pw.println(this.nombres + "|" + this.apellidos + "|" + this.organizacion + "|" + this.correo + "|" + this.clave);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Comprador> readFile(String nomfile) {
        ArrayList<Comprador> compradores = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador e = new Comprador(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                compradores.add(e);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return compradores;
    }

    public static boolean ComprobarCorreoComprador(String nomfile, String Email) {
        ArrayList<Comprador> compradores = Comprador.readFile(nomfile);
        for (Comprador c : compradores) {
            if (c.correo.equals(Email)) {
                return false;
            }
        }
        return true;
    }

    public static void OfertarVehiculo(Scanner sc) {
        System.out.println("Ingrese tipo de vehiculo de su interes: ");
        String tipo = sc.next();
        System.out.println("Ingrese rango de recorrido de busqueda");
        System.out.println("rango Minimo: ");
        double recorridoMin = sc.nextDouble();
        System.out.println("rango Maximo: ");
        double recorridoMax = sc.nextDouble();
        System.out.println("Ingrese rango del Año de busqueda");
        System.out.println("rango Minimo: ");
        int añoMin = sc.nextInt();
        System.out.println("rango Maximo: ");
        int añoMax = sc.nextInt();
        System.out.println("Ingrese rango del precio de busqueda");
        System.out.println("rango Minimo: ");
        double precioMin = sc.nextDouble();
        System.out.println("rango Maximo: ");
        double precioMax = sc.nextDouble();
        ArrayList<Vehiculo> vehiculosCondicion = new ArrayList<>();
        ArrayList<Vehiculo> VehiculossinRestriccion = Vehiculo.readFile("Vehiculos.txt");
        boolean siguiente = true;
        int indice = 0;
        if (tipo.equalsIgnoreCase("auto") || tipo.equalsIgnoreCase("moto") || tipo.equalsIgnoreCase("camioneta")) {
            String firstLtr = tipo.substring(0, 1);
            String restLtrs = tipo.substring(1, tipo.length());
            firstLtr = firstLtr.toUpperCase();
            String tipo_Mayus = firstLtr + restLtrs;
            ArrayList<Vehiculo> VehiculoxTipo = Vehiculo.readFile(tipo_Mayus + "s.txt");
            if (recorridoMin >= 0 && recorridoMax > recorridoMin && añoMin >= 0 && añoMax > añoMin && precioMin >= 0 && precioMax > precioMin) {
                for (Vehiculo v : VehiculoxTipo) {
                    if (v.recorrido >= recorridoMin && v.recorrido <= recorridoMax && v.año >= añoMin && v.año <= añoMax && v.precio >= precioMin && v.precio <= precioMax) {
                        vehiculosCondicion.add(v);
                    }
                }
                while (siguiente = true) {
                    System.out.println("Vehiculo # " + indice + 1);
                    System.out.println("Placa: " + vehiculosCondicion.get(indice).placa);
                    System.out.println("Marca: " + vehiculosCondicion.get(indice).marca);
                    System.out.println("Modelo: " + vehiculosCondicion.get(indice).modelo);
                    System.out.println("Tipo de motor: " + vehiculosCondicion.get(indice).motor);
                    System.out.println("Año: " + vehiculosCondicion.get(indice).año);
                    System.out.println("Recorrido: " + vehiculosCondicion.get(indice).recorrido);
                    System.out.println("Color: " + vehiculosCondicion.get(indice).color);
                    System.out.println("Tipo de Combustible: " + vehiculosCondicion.get(indice).combustible);
                    System.out.println("Precio: " + vehiculosCondicion.get(indice).precio);
                    if (vehiculosCondicion.size() > 1) {
                        if (indice < vehiculosCondicion.size() && indice == 0) {
                            System.out.println("Continuar? de ser asi marque S: ");
                            String desicion = sc.next();
                            if (desicion.equals("S") || desicion.equals("s")) {
                                indice++;
                            }
                            System.out.println("Placa: " + vehiculosCondicion.get(indice).placa);
                            System.out.println("Marca: " + vehiculosCondicion.get(indice).marca);
                            System.out.println("Modelo: " + vehiculosCondicion.get(indice).modelo);
                            System.out.println("Tipo de motor: " + vehiculosCondicion.get(indice).motor);
                            System.out.println("Año: " + vehiculosCondicion.get(indice).año);
                            System.out.println("Recorrido: " + vehiculosCondicion.get(indice).recorrido);
                            System.out.println("Color: " + vehiculosCondicion.get(indice).color);
                            System.out.println("Tipo de Combustible: " + vehiculosCondicion.get(indice).combustible);
                            System.out.println("Precio: " + vehiculosCondicion.get(indice).precio);
                        }
                        if (indice > 0 && indice < vehiculosCondicion.size() - 1) {
                            System.out.println("Continuar? de ser asi marque S, si desea regresar al vehiculo anterior marque R: ");
                            String desicion = sc.next();
                            if (desicion.equals("S") || desicion.equals("s")) {
                                indice++;
                            }
                            if (desicion.equals("R") || desicion.equals("r")) {
                                indice--;
                            }
                            System.out.println("Placa: " + vehiculosCondicion.get(indice).placa);
                            System.out.println("Marca: " + vehiculosCondicion.get(indice).marca);
                            System.out.println("Modelo: " + vehiculosCondicion.get(indice).modelo);
                            System.out.println("Tipo de motor: " + vehiculosCondicion.get(indice).motor);
                            System.out.println("Año: " + vehiculosCondicion.get(indice).año);
                            System.out.println("Recorrido: " + vehiculosCondicion.get(indice).recorrido);
                            System.out.println("Color: " + vehiculosCondicion.get(indice).color);
                            System.out.println("Tipo de Combustible: " + vehiculosCondicion.get(indice).combustible);
                            System.out.println("Precio: " + vehiculosCondicion.get(indice).precio);
                        } else {
                            System.out.println("Desea retroceder o salir?  marque R para retroceder o E para salir: ");
                            String desicion = sc.next();
                            if (desicion.equals("R") || desicion.equals("r")) {
                                indice--;
                            }
                            if (desicion.equals("E") || desicion.equals("e")) {
                                System.out.println("Regresando a inicio...");
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            while (siguiente = true) {
                System.out.println("Vehiculo # " + indice + 1);
                System.out.println("Placa: " + VehiculossinRestriccion.get(indice).placa);
                System.out.println("Marca: " + VehiculossinRestriccion.get(indice).marca);
                System.out.println("Modelo: " + VehiculossinRestriccion.get(indice).modelo);
                System.out.println("Tipo de motor: " + VehiculossinRestriccion.get(indice).motor);
                System.out.println("Año: " + VehiculossinRestriccion.get(indice).año);
                System.out.println("Recorrido: " + VehiculossinRestriccion.get(indice).recorrido);
                System.out.println("Color: " + VehiculossinRestriccion.get(indice).color);
                System.out.println("Tipo de Combustible: " + VehiculossinRestriccion.get(indice).combustible);
                System.out.println("Precio: " + VehiculossinRestriccion.get(indice).precio);
                if (VehiculossinRestriccion.size() > 1) {
                    if (indice < VehiculossinRestriccion.size() && indice == 0) {
                        System.out.println("Continuar? de ser asi marque S: ");
                        String desicion = sc.next();
                        if (desicion.equals("S") || desicion.equals("s")) {
                            indice++;
                        }
                        System.out.println("Placa: " + VehiculossinRestriccion.get(indice).placa);
                        System.out.println("Marca: " + VehiculossinRestriccion.get(indice).marca);
                        System.out.println("Modelo: " + VehiculossinRestriccion.get(indice).modelo);
                        System.out.println("Tipo de motor: " + VehiculossinRestriccion.get(indice).motor);
                        System.out.println("Año: " + VehiculossinRestriccion.get(indice).año);
                        System.out.println("Recorrido: " + VehiculossinRestriccion.get(indice).recorrido);
                        System.out.println("Color: " + VehiculossinRestriccion.get(indice).color);
                        System.out.println("Tipo de Combustible: " + VehiculossinRestriccion.get(indice).combustible);
                        System.out.println("Precio: " + VehiculossinRestriccion.get(indice).precio);
                    }
                    if (indice > 0 && indice < VehiculossinRestriccion.size() - 1) {
                        System.out.println("Continuar? de ser asi marque S, si desea regresar al vehiculo anterior marque R: ");
                        String desicion = sc.next();
                        if (desicion.equals("S") || desicion.equals("s")) {
                            indice++;
                        }
                        if (desicion.equals("R") || desicion.equals("r")) {
                            indice--;
                        }
                        System.out.println("Placa: " + VehiculossinRestriccion.get(indice).placa);
                        System.out.println("Marca: " + VehiculossinRestriccion.get(indice).marca);
                        System.out.println("Modelo: " + VehiculossinRestriccion.get(indice).modelo);
                        System.out.println("Tipo de motor: " + VehiculossinRestriccion.get(indice).motor);
                        System.out.println("Año: " + VehiculossinRestriccion.get(indice).año);
                        System.out.println("Recorrido: " + VehiculossinRestriccion.get(indice).recorrido);
                        System.out.println("Color: " + VehiculossinRestriccion.get(indice).color);
                        System.out.println("Tipo de Combustible: " + VehiculossinRestriccion.get(indice).combustible);
                        System.out.println("Precio: " + VehiculossinRestriccion.get(indice).precio);
                    } else {
                        System.out.println("Desea retroceder o salir?  marque R para retroceder o E para salir: ");
                        String desicion = sc.next();
                        if (desicion.equals("R") || desicion.equals("r")) {
                            indice--;
                        }
                        if (desicion.equals("E") || desicion.equals("e")) {
                            System.out.println("Fin del programa");
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Nombres: " + this.nombres + " Apellidos: " + this.apellidos + " Correo electronico: " + this.correo + " Organizacion: " + this.organizacion;
    }
}
