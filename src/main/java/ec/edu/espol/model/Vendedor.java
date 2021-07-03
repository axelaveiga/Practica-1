
package ec.edu.espol.model;

import java.util.Scanner;

/**
 *
 * @author Josue Vera
 */
public class Vendedor extends Persona{
    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave){
        super(nombres,apellidos,correo,organizacion,clave);
    }
    public static Vendedor RegistarVendedor(Scanner sc){
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
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena=sc.next();
        String contrasenaConvertida=Persona.convertirSHA256(contrasena);
        Vendedor v=new Vendedor(nombre,apellidos,organizacion,correo,contrasenaConvertida);
        return v;
    }

         public Vehiculo RegistrarVehiculo(Scanner sc){
         System.out.println("Ingrese el tipo de vehiculo que quiere registrar: ");
         String tipo= sc.next();
         if (tipo.equalsIgnoreCase("auto"))
           Autos.DatosAuto(sc);
         if (tipo.equalsIgnoreCase("moto"))
           Motos.DatosMoto(sc);
         if (tipo.equalsIgnoreCase("camioneta"))
           Camioneta.DatosCamioneta(sc);
        return null;
     }
    @Override
    public String toString(){
        return "Nombres: "+this.nombres+" Apellidos: "+this.apellidos+" Correo electronico: "+this.correo+" Organizacion: "+this.organizacion ;
    }
}
