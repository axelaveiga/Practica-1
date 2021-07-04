/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ProyectoPOO;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Persona;
import ec.edu.espol.model.Vendedor;
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
        Scanner sc=new Scanner(System.in);
        Vendedor v=Vendedor.RegistarVendedor(sc);
        System.out.println(v);
    //Guarda la informacion del vendedor
        v.saveFile("ArchivoVendedores.txt");
    //Guarda la informacion del comprador    
        Comprador c=Comprador.RegistarComprador(sc);
        System.out.println(c);
        c.saveFile("ArchivoCompradores.txt");
    
    }
    
}
