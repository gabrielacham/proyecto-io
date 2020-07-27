
package Ventanas;

/**
 *
 * @author Kharen
 */
public class Rango {
    private double minimo;
    private double maximo;
    private int valor;
    
    //Constructor con parametros
    public Rango(double minimo, double maximo, int valor){
        this.minimo = minimo;
        this.maximo = maximo;
        this.valor = valor;
    }
    
    //Metodos sets
    public void setMinimo(double minimo){
        this.minimo = minimo;
    }
    
    public void setMaximo(double maximo){
        this.maximo = maximo;
    }
    public void setValor (int valor){
        this.valor = valor;
    }
    //Metodos gets
    public double getMinimo(){
        return minimo;
    }
    public double getMaximo(){
        return maximo;
    }
    public int getValor(){
        return valor;
    }
    
}
