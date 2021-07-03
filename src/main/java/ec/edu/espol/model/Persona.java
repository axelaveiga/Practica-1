/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author Josue Vera
 */
public class Persona {
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String organizacion;
    protected String clave;

    public Persona(String nombres, String apellidos, String correo, String organizacion, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.organizacion = organizacion;
        this.clave = clave;
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
        public static boolean validarEmail(String email){
        boolean valido = false;
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
