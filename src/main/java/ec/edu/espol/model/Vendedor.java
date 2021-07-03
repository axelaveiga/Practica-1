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

    public static boolean validarEmail(String email) {
        boolean valido = false;
        String local;
        String dominio;
        char[] caracteres = {'(', ')', '[', ']', '\\', ',', ';', ':', '<', '>', ' '};
        int posicionArroba = email.indexOf('@');
        if (posicionArroba != -1) {
            local = email.substring(0, posicionArroba);
            dominio = email.substring(posicionArroba + 1, email.length());
            if (local.length() > 0 && dominio.length() > 0) {
                int posicionPunto = local.lastIndexOf('.');
                if (posicionPunto == -1) {
                    for (int i = 0; i < local.length(); i++) {
                        for (int j = 0; j < caracteres.length; j++) {
                            if (local.charAt(i) != caracteres[j]) {
                                valido = true;
                            }
                        }
                    }
                }
            }
        }
        return valido;
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
        while (Vendedor.validarEmail(correo) == false) {
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena = sc.next();

        Vendedor v = new Vendedor(nombre, apellidos, organizacion, correo, contrasena);
        return v;
    }

    // Funcion: Agregar String a un archivo
    //@autor Axel Aveiga
    public void saveFile(String nomfile) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true)))
            {
                pw.println(this.nombres +"|"+ this.apellidos +"|"+ this.organizacion+"|"+ this.correo +"|"+ this.clave);
            }
        catch(Exception e) {System.out.println(e.getMessage());
                    }
        }
    
    
    @Override
    public String toString() {
        return "Nombres: " + this.nombres + " Apellidos: " + this.apellidos + " Correo electronico: " + this.correo + " Organizacion: " + this.organizacion;
    }
}
