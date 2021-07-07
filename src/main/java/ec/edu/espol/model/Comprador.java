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
public class Comprador extends Persona{
    public Comprador(String nombres, String apellidos, String correo, String organizacion, String clave){
        super(nombres,apellidos,correo,organizacion,clave);
    }
        public static Comprador RegistarComprador(Scanner sc){
        System.out.println("Ingrese sus nombres: ");
        String nombre=sc.nextLine();
        System.out.println("Ingrese sus Apellidos: ");
        String apellidos=sc.nextLine();
        System.out.println("Ingrese la Organizacion donde trabaja: ");
        String organizacion=sc.nextLine();
        System.out.println("Ingrese su correo electronico: ");
        String correo=sc.next();
        while (Persona.validarEmail(correo)==false){
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n=sc.next();
            correo=correo.replaceAll(correo,correo_n);
        }
        boolean estar=Persona.ComprobarCorreo("ArchivoCompradores.txt", correo);
        while (estar==false){
            System.out.println("El correo ingresado ya esta registrado, ingrese correo electronico valido: ");
            String correo_n=sc.next();
            correo=correo.replaceAll(correo,correo_n);
             estar=Persona.ComprobarCorreo("ArchivoCompradores.txt", correo);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena=sc.next();

        String contrasenaConvertida=Persona.convertirSHA256(contrasena);
        Comprador c=new Comprador(nombre,apellidos,organizacion,correo,contrasenaConvertida);
        return c;
    }
        public void saveFile(String nomfile) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true)))
            {
                pw.println(this.nombres +"|"+ this.apellidos +"|"+ this.organizacion+"|"+ this.correo +"|"+ this.clave);
            }
        catch(Exception e) {System.out.println(e.getMessage());
                    }
        }
        public static ArrayList<Comprador> readFile(String nomfile){
        ArrayList<Comprador> compradores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador e = new Comprador(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
                compradores.add(e);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return compradores;
    }
    @Override
    public String toString(){
        return "Nombres: "+this.nombres+" Apellidos: "+this.apellidos+" Correo electronico: "+this.correo+" Organizacion: "+this.organizacion ;
    }

}
