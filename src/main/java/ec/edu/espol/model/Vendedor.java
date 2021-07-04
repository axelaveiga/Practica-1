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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public static Vendedor  RegistarVendedor(Scanner sc){
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
        Vendedor.aniadirLista(correo);
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena=sc.next();
       
        Vendedor v=new Vendedor(nombre,apellidos,organizacion,correo,contrasena);
        return v;
    }

    public static ArrayList<String> aniadirLista(String correo) {
        ArrayList<String> listaCorreos=new ArrayList<>();
        if(!(listaCorreos.contains(correo)))
            listaCorreos.add(correo);
        return listaCorreos;
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
    
    }
    
    
