
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
           System.out.println("M enu de opciones");
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
           int numero_op=sc.nextInt();
           while(!(numero_op>0 && numero_op<=3)){
               System.out.println("Ingrese opcion valida: ");
               numero_op=sc.nextInt();
           }
           return numero_op;
    }
    public void MenuGeneral(Scanner sc){ 
        int opM=Menu.cargarMenu(sc);
        System.out.println(opM);
        if(opM==1){
            int opV=Menu.cargarMenuVendedor(sc);
            System.out.println(opV);
            if(opV==1){
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

