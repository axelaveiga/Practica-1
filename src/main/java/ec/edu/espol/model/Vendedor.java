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
public class Vendedor extends Persona{
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave){
        super(nombres,apellidos,correo,organizacion,clave);
    }

    public String getNombresVendedor() {
        return nombres;
    }

    public void setNombresVendedor(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidosVendedor() {
        return apellidos;
    }

    public void setApellidosVendedor(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoVendedor() {
        return correo;
    }

    public void setCorreoVendedor(String correo) {
        this.correo = correo;
    }

    public String getOrganizacionVendedor() {
        return organizacion;
    }

    public void setOrganizacionVendedor(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClaveVendedor() {
        return clave;
    }

    public void setClaveVendedor(String clave) {
        this.clave = clave;
    }
    
    public static void RegistarVendedor(Scanner sc){
        System.out.println("Ingrese sus nombres: ");
        String nombre=sc.next();
        System.out.println("Ingrese sus Apellidos: ");
        String apellidos=sc.next();
        System.out.println("Ingrese la Organizacion donde trabaja: ");
        String organizacion=sc.next();
        System.out.println("Ingrese su correo electronico: ");
        String correo=sc.next();
        while (Persona.validarEmail(correo)==false){
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n=sc.next();
            correo=correo.replaceAll(correo,correo_n);
        }
        boolean estar=Persona.ComprobarCorreo("ArchivoVendedores.txt", correo);
        while (estar==false){
            System.out.println("El correo ingresado ya esta regsitrado, ingrese correo electronico valido: ");
            String correo_n=sc.next();
            correo=correo.replaceAll(correo,correo_n);
             estar=Persona.ComprobarCorreo("ArchivoVendedores.txt", correo);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena=sc.next();
        Vendedor v=new Vendedor(nombre,apellidos,organizacion,correo,Persona.convertirSHA256(contrasena));
        v.saveFile("ArchivoVendedores.txt");
    }

    public void saveFile(String nomfile) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true)))
            {
                pw.println(this.nombres +"|"+this.apellidos +"|"+this.organizacion+"|"+this.correo +"|"+ this.clave);
            }
        catch(Exception e) {System.out.println(e.getMessage());
                    
        }
}
         public Vehiculo RegistrarVehiculo(Scanner sc){
         System.out.println("Ingrese el tipo de vehiculo que quiere registrar: ");
         String tipo= sc.next();
         while ((tipo.equalsIgnoreCase("auto")||tipo.equalsIgnoreCase("moto")||tipo.equalsIgnoreCase("camioneta"))== false){
             System.out.println("Ingrese si su vehiculo es: auto-moto-camioneta");
             String tipon= sc.next();
             tipo=tipo.replaceAll(tipo,tipon);  
         }
         if (tipo.equalsIgnoreCase("auto"))
           Autos.DatosAuto(sc);
        if (tipo.equalsIgnoreCase("moto"))
           Motos.DatosMoto(sc);
        if (tipo.equalsIgnoreCase("camioneta"))
           Camioneta.DatosCamioneta(sc);
        return null;
     }
         public static ArrayList<Vendedor> readFile(String nomfile){
        ArrayList<Vendedor> Vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor e = new Vendedor(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
                Vendedores.add(e);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return Vendedores;
    }
        
    }
    
    
