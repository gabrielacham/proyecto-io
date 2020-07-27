
package Ventanas;

/**
 *
 * @author Kharen
 */
public class Inventario {
    private int invInicial;
    private int invFinal;
    private double invProm;
    private int faltantes;
    private int tiempo;

    public Inventario() {
        invInicial = 0;
        invFinal = 0;
        invProm = 0.00;
        faltantes = 0;
        tiempo = 0;
    }
    //Metodos setters

    public void setInvInicial(int invInicial) {
        this.invInicial = invInicial;
    }

    public void setInvFinal(int invFinal) {
        this.invFinal = invFinal;
    }

    public void setInvProm(double invProm) {
        this.invProm = invProm;
    }

    public void setFaltantes(int faltantes) {
        this.faltantes = faltantes;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    //Metodos getters

    public int getInvInicial() {
        return invInicial;
    }

    public int getInvFinal() {
        return invFinal;
    }

    public double getInvProm() {
        return invProm;
    }

    public int getFaltantes() {
        return faltantes;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    
    
}
