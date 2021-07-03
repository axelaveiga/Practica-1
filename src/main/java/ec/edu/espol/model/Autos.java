/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;


/**
 *
 * @author Axel
 */
public class Autos extends Vehiculo{
    protected String vidrios;
    protected String transmision;

    public Autos(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio, String transmision) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
        this.transmision=  transmision;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
    
    public boolean validarEmail(String email){
        boolean valido = false;

        int antesArroba;
        int antesPunto;
        String local;
        String dominio;
        char [] caracteres = {'(', ')', '[', ']', '\\',',', ';',':', '<', '>', ' '};
        int posicionArroba = email.indexOf('@');
        if (posicionArroba != -1){
          local = email.substring(0,posicionArroba);
          dominio= email.substring(posicionArroba + 1,email.length());
          if(local.length()> 0 && dominio.length() > 0){
              int posicionPunto = local.lastIndexOf('.');
              if(posicionPunto == -1){
                for (int i = 0; i < local.length(); i++) {
                  for (int j = 0; j < caracteres.length; j++) {
                    if(local.charAt(i)!= caracteres[j]){
                      valido = true;
                    }
                  }
                }
              }
            }
          }
        return valido;
    }
    
    
}
