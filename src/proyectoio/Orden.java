
package proyectoio;

/**
 *
 * @author Kharen
 */
public class Orden {
    private double costoOrden;
    private int q;
    private int tiempEnt;
    private int numOrden;
    
    //Constructor con parametros

    public Orden(double costoOrden, int q, int tiempEnt, int numOrden) {
        this.costoOrden = costoOrden;
        this.q = q;
        this.tiempEnt = tiempEnt;
        this.numOrden = numOrden;
    }
    //Metodos setters
    public void setCostoOrden(double costoOrden) {
        this.costoOrden = costoOrden;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setTiempEnt(int tiempEnt) {
        this.tiempEnt = tiempEnt;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }
    //Metodos getters

    public double getCostoOrden() {
        return costoOrden;
    }

    public int getQ() {
        return q;
    }

    public int getTiempEnt() {
        return tiempEnt;
    }

    public int getNumOrden() {
        return numOrden;
    }

  
    
}
