/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Josue Vera
 */
public class Vendedor extends Persona {

    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
    }
    public static Vendedor RegistarVendedor(Scanner sc) {
        System.out.println("Ingrese sus nombres: ");
        String nombre = sc.next();
        System.out.println("Ingrese sus Apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese la Organizacion donde trabaja: ");
        String organizacion = sc.next();
        System.out.println("Ingrese su correo electronico: ");
        String correo = sc.next();
        while (Persona.validarEmail(correo) == false) {
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena = sc.next();

        Vendedor v = new Vendedor(nombre, apellidos, organizacion, correo, contrasena);
        return v;
    }
    
    @Override
    public String toString() {
        return "Nombres: " + this.nombres + " Apellidos: " + this.apellidos + " Correo electronico: " + this.correo + " Organizacion: " + this.organizacion;
    }   
}
