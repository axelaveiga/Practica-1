
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
}
