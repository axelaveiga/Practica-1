
package ec.edu.espol.model;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Menu extends Persona{

    public Menu(String nombres, String apellidos, String correo, String organizacion, String clave){
        super(nombres,apellidos,correo,organizacion,clave); 
    }
    public final static int  cargarMenu(Scanner sc){
           System.out.println("Menu de opciones");
           System.out.println("1. Vendedor");
           System.out.println("2. Comprador");
           System.out.println("3. Salir");
           System.out.println("ingresa una de las opciones: ");
           int numero_op=sc.nextInt();
           while(!(numero_op>0 && numero_op<=3)){
               System.out.println("Ingrese opcion valida: ");
               numero_op=sc.nextInt();
           }
           return numero_op;
    } 
    public final static int  cargarMenuVendedor(Scanner sc){
           System.out.println("1. Registrar un nuevo vendedor");
           System.out.println("2. Ingresar un nuevo vehiculo");
           System.out.println("3. Aceptar oferta");
           System.out.println("4. Regresar");
           System.out.println("Ingrese opcion: ");
           int numero_op=sc.nextInt();
           while(!(numero_op>0 && numero_op<=4)){
               System.out.println("Ingrese opcion valida: ");
               numero_op=sc.nextInt();
           }
           return numero_op;
    }
    public final static int  cargarMenuComprador(Scanner sc){
           System.out.println("1. Registrar un nuevo comprador");
           System.out.println("2. ofertar por un vehiculo");
           System.out.println("3. Regresar");
           System.out.println("Ingrese opcion: ");
           int numero_op=sc.nextInt();
           while(!(numero_op>0 && numero_op<=3)){
               System.out.println("Ingrese opcion valida: ");
               numero_op=sc.nextInt();
           }
           return numero_op;
    }
    public void MenuGeneral(Scanner sc){ 
        int opM=Menu.cargarMenu(sc);
        if(opM==1){
            int opV=Menu.cargarMenuVendedor(sc);
            if(opV==1){
                Vendedor.RegistarVendedor(sc);
            }
            if(opV==2){
            System.out.println("Ingrese su correo electronico: ");
                String correo=sc.next();
                System.out.println("Ingrese su contraseña: ");
                String contrasenia=sc.next();
                boolean permiso=Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
                while(permiso==false){
                    System.out.println("El usuario o contraseña ingresados son incorrectos, ingrese creedenciales nuevamente: ");
                    System.out.println("Ingrese su correo electronico: ");
                    String correo_n=sc.next();
                    System.out.println("Ingrese su contraseña: ");
                    String contrasenia_n=sc.next();
                    correo=correo.replaceAll(contrasenia,contrasenia_n);
                    permiso=Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
                }
                Vendedor.RegistarVendedor(sc);
            }
            
            //DEMAS OPCIONES
            if(opV==4){
            //REGRESO    
            }
        }
        if(opM==2){
            int opC=Menu.cargarMenuComprador(sc);
            System.out.println(opC);
            if(opC==1){
            Comprador.RegistarComprador(sc);
            }
            //DEMAS OPCIONES
            if(opC==3){
            //REGRESO
            }
            
        }
        else
            System.out.println("Salida con exito");
    }
}

