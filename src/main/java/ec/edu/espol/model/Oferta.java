/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Josue Vera
 */
public class Oferta {
    private String correo;
    private String precio;
    
  public Oferta(String correo, String precio){
      this.correo=  correo;
      this.precio= precio;
  }
   public void saveFile(String nomfile) {
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true)))
            {
                pw.println(this.correo +"|"+this.precio );
            }
        catch(Exception e) {System.out.println(e.getMessage());
                    
        }
}
}
