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
 * @author Axel
 */
public class Vehiculo {

    protected String placa;
    protected String marca;
    protected String modelo;
    protected String motor;
    protected int año;
    protected double recorrido;
    protected String color;
    protected String combustible;
    protected double precio;

    public Vehiculo(String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void saveFile(String nomfile) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true))) {
            pw.println(this.placa + "|" + this.marca + "|" + this.modelo + "|" + this.motor + "|" + this.año + "|" + this.recorrido + "|" + this.color + "|" + this.combustible + "|" + this.precio);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static ArrayList<Vehiculo> readFile(String nomfile) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo v = new Vehiculo(tokens[0], tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), Double.parseDouble(tokens[5]), tokens[6], tokens[7], Double.parseDouble(tokens[8]));
                vehiculos.add(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }

    public static boolean ComprobarPlaca(String nomfile, String placa) {
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nomfile);
        for (Vehiculo v : vehiculos) {
            if (v.placa.equals(placa)) {
                return true;
            }
        }
        return false;
    }

}
