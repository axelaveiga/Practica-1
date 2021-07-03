/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectopoo;

/**
 *
 * @author Axel
 */
public class Autos extends Vehiculo{
    protected String vidrios;
    protected String transmision;

    public Autos(String vidrios, String placa, String marca, String modelo, String motor, int año, double recorrido, String color, String combustible, double precio) {
        super(placa, marca, modelo, motor, año, recorrido, color, combustible, precio);
        this.vidrios = vidrios;
    }
    
    
}
