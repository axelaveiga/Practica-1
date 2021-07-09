/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josue Vera
 */
public class Oferta {
    protected String correo;
    protected double precio;
    private String placa;
    
  public Oferta(String correo, double precio, String placa){
      this.correo=  correo;
      this.precio= precio;
      this.placa= placa;
  }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
  
   public void saveFile(String nomfile) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true)))
            {
                pw.println(this.correo +"|"+this.precio );
            }
        catch(Exception e) {System.out.println(e.getMessage());
                    
        }
}
            public static ArrayList<Oferta> readFile(String nomfile){
        ArrayList<Oferta> Ofertas= new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
               Oferta o = new Oferta(tokens[0],Double.parseDouble(tokens[1]),tokens[2]);
                Ofertas.add(o);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return Ofertas;
    }
}
