
package Ventanas;

import Ventanas.Cliente;

/**
 *
 * @author Kharen
 */
public class Compra {
    private int uniVend;
    private int uniFalt;
    private int tiempo;
    private Cliente cliente;
    
    //Constructor  con parametros

    public Compra(int uniVend, int uniFalt, int tiempo, Cliente cliente) {
        this.uniVend = uniVend;
        this.uniFalt = uniFalt;
        this.tiempo = tiempo;
        this.cliente = cliente;
    }
    //Metodos setters
    
    
    
    public void setUniVend(int uniVend) {
        this.uniVend = uniVend;
    }

    public void setUniFalt(int uniFalt) {
        this.uniFalt = uniFalt;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //Metodos getters
    public int getUniVend() {
        return uniVend;
    }

    public int getUniFalt() {
        return uniFalt;
    }

    public int getTiempo() {
        return tiempo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
