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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Josue Vera
 */
public class Vendedor extends Persona {

    public Vendedor(String nombres, String apellidos, String correo, String organizacion, String clave) {
        super(nombres, apellidos, correo, organizacion, clave);
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

    public static void RegistarVendedor(Scanner sc) {
        System.out.println("Ingrese sus nombres: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese sus Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Ingrese la Organizacion donde trabaja: ");
        String organizacion = sc.nextLine();
        System.out.println("Ingrese su correo electronico: ");
        String correo = sc.next();
        while (Persona.validarEmail(correo) == false) {
            System.out.println("Ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
        }
        boolean estar = Vendedor.ComprobarCorreoVendedor("ArchivoVendedores.txt", correo);
        while (estar == false) {
            System.out.println("El correo ingresado ya esta registrado, ingrese correo electronico valido: ");
            String correo_n = sc.next();
            correo = correo.replaceAll(correo, correo_n);
            estar = Vendedor.ComprobarCorreoVendedor("ArchivoVendedores.txt", correo);
        }
        System.out.println("Ingrese su clave de acceso: ");
        String contrasena = sc.next();
        Vendedor v = new Vendedor(nombre, apellidos, organizacion, correo, Persona.convertirSHA256(contrasena));
        v.saveFile("ArchivoVendedores.txt");
    }

    public void saveFile(String nomfile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true))) {
            pw.println(this.nombres + "|" + this.apellidos + "|" + this.organizacion + "|" + this.correo + "|" + this.clave);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static void RegistrarVehiculo(Scanner sc) {
        System.out.println("Ingrese su correo electronico: ");
        String correo = sc.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasenia = sc.next();
        boolean permiso = Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
        while (permiso == false) {
            System.out.println("El usuario o contraseña ingresados son incorrectos, ingrese creedenciales nuevamente: ");
            System.out.println("Ingrese su correo electronico: ");
            String correo_n = sc.next();
            System.out.println("Ingrese su contraseña: ");
            String contrasenia_n = sc.next();
            correo = correo.replaceAll(contrasenia, contrasenia_n);
            permiso = Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
        }
        System.out.println("Ingrese el tipo de vehiculo que quiere registrar: ");
        String tipo = sc.nextLine();
        while ((tipo.equalsIgnoreCase("auto") || tipo.equalsIgnoreCase("moto") || tipo.equalsIgnoreCase("camioneta")) == false) {
            System.out.println("Ingrese si su vehiculo es: auto-moto-camioneta");
            String tipon = sc.nextLine();
            tipo = tipo.replaceAll(tipo, tipon);
        }
        if (tipo.equalsIgnoreCase("auto")) {
            Autos.DatosAuto(sc);
        }
        if (tipo.equalsIgnoreCase("moto")) {
            Motos.DatosMoto(sc);
        }
        if (tipo.equalsIgnoreCase("camioneta")) {
            Camioneta.DatosCamioneta(sc);
        }
    }

    public static ArrayList<Vendedor> readFile(String nomfile) {
        ArrayList<Vendedor> Vendedores = new ArrayList<>();
        try ( Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor e = new Vendedor(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                Vendedores.add(e);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Vendedores;
    }

    public static boolean ComprobarCorreoVendedor(String nomfile, String Email) {
        ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
        for (Vendedor v : vendedores) {
            if (v.correo.equals(Email)) {
                return false;
            }
        }
        return true;
    }

    public static boolean ComprobarCreedencialesVendedor(String nomfile, String correo, String contrasenia) {
        ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
        String contrasena_login = Persona.convertirSHA256(contrasenia);
        for (Vendedor v : vendedores) {
            if (v.correo.contains(correo) && v.clave.contains(contrasena_login)) {
                return true;
            }
        }
        return false;
    }

    public static void AceptarOferta(Scanner sc) {
        System.out.println("Ingrese su correo electronico: ");
        String correo = sc.next();
        System.out.println("Ingrese su contraseña: ");
        String contrasenia = sc.next();
        boolean permiso = Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
        while (permiso == false) {
            System.out.println("El usuario o contraseña ingresados son incorrectos, ingrese creedenciales nuevamente: ");
            System.out.println("Ingrese su correo electronico: ");
            String correo_n = sc.next();
            System.out.println("Ingrese su contraseña: ");
            String contrasenia_n = sc.next();
            correo = correo.replaceAll(contrasenia, contrasenia_n);
            permiso = Vendedor.ComprobarCreedencialesVendedor("ArchivoVendedores.txt", correo, contrasenia);
        }
        int indice = 0;
        boolean siguiente = true;

        System.out.println("Ingrese placa del vehiculo: ");
        String placa = sc.nextLine();
        ArrayList<Oferta> ofertas = Oferta.readFile("Ofertas.txt");
        ArrayList<Oferta> Ofertasseleccionadas = new ArrayList<>();
        for (Oferta o : ofertas) {
            if (o.getPlaca().equals(placa)) {
                Ofertasseleccionadas.add(o);
            }
        }
        while (siguiente == true) {
            System.out.println("Oferta" + indice + 1);
            System.out.println("Correo: " + Ofertasseleccionadas.get(indice).correo);
            System.out.println("Precio Ofertado : " + Ofertasseleccionadas.get(indice).precio);
            System.out.println("Dese aceptar esta oferta?: S para aceptar, cualquier otra letra para continuar revizando las ofertas");
            String opcion=sc.next();
            if(opcion.equals("S")||opcion.equals("s"))
                Vendedor.enviarConGMail(correo, contrasenia, Ofertasseleccionadas.get(indice).correo, "VENTA DE VEHICULO", "VENTA EN PROCESO, COMINIQUESE CON EL VENDEDOR POR ESTE MEDIO");
            if (Ofertasseleccionadas.size() > 1) {
                if (indice < Ofertasseleccionadas.size() && indice == 0) {
                    System.out.println("Continuar? de ser asi marque S: ");
                    String desicion = sc.next();
                    if (desicion.equals("S") || desicion.equals("s")) {
                        indice++;
                    }
                    System.out.println("Correo: " + Ofertasseleccionadas.get(indice).correo);
                    System.out.println("Precio Ofertad : " + Ofertasseleccionadas.get(indice).precio);
                    System.out.println("Dese aceptar esta oferta?: S para aceptar, cualquier otra letra para continuar revizando las ofertas");
                    opcion=sc.next();
                    if(opcion.equals("S")||opcion.equals("s"))
                        Vendedor.enviarConGMail(correo, contrasenia, Ofertasseleccionadas.get(indice).correo, "VENTA DE VEHICULO", "VENTA EN PROCESO, COMINIQUESE CON EL VENDEDOR POR ESTE MEDIO");
                    

                }
                if (indice > 0 && indice < Ofertasseleccionadas.size() - 1) {
                    System.out.println("Continuar? de ser asi marque S, si desea regresar al vehiculo anterior marque R: ");
                    String desicion = sc.next();
                    if (desicion.equals("S") || desicion.equals("s")) {
                        indice++;
                    }
                    if (desicion.equals("R") || desicion.equals("r")) {
                        indice--;
                    }
                    System.out.println("Correo: " + Ofertasseleccionadas.get(indice).correo);
                    System.out.println("Precio Ofertad : " + Ofertasseleccionadas.get(indice).precio);
                    System.out.println("Dese aceptar esta oferta?: S para aceptar, cualquier otra letra para continuar revizando las ofertas");
                    opcion=sc.next();
                    if(opcion.equals("S")||opcion.equals("s"))
                        Vendedor.enviarConGMail(correo, contrasenia, Ofertasseleccionadas.get(indice).correo, "VENTA DE VEHICULO", "VENTA EN PROCESO, COMINIQUESE CON EL VENDEDOR POR ESTE MEDIO");
                } else {
                    System.out.println("Desea retroceder o salir?  marque R para retroceder o E para salir: ");
                    String desicion = sc.next();
                    if (desicion.equals("R") || desicion.equals("r")) {
                        indice--;
                    }
                    if (desicion.equals("E") || desicion.equals("e")) {
                        System.out.println("Regresando a inicio...");
                        break;
                    }
                }
            }
        }
    }
    public static void enviarConGMail(String remitente, String clave,String destinatario, String asunto, String cuerpo) {
    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com"); 
    props.put("mail.smtp.user", remitente);
    props.put("mail.smtp.clave", "miClaveDeGMail");   
    props.put("mail.smtp.auth", "true");   
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.port", "587");     
    Session session = Session.getInstance(props,null);
    MimeMessage message = new MimeMessage(session);
    try {
        message.setFrom(new InternetAddress(remitente));
        message.addRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(destinatario) });
        message.setSubject(asunto);
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
}
    @Override
    public String toString() {
        return "Nombres: " + this.nombres + " Apellidos: " + this.apellidos + " Correo electronico: " + this.correo + " Organizacion: " + this.organizacion;
    }

}