
package proyectoio;

import java.text.DecimalFormat;

/**
 *
 * @author Kharen
 */
public class Costos {

    private int q;
    private int r;
    private double costComp;
    private double costInv;
    private double costOrden;
    private double costFE;
    private double costFSE;
    private double costFT;
    private double costInvA;
    private double costTotal;
    
    //Constructor sin parametros
    public Costos(){
        q = 0;
        r = 0;
        costComp = 0.00;
        costInv = 0.00;
        costOrden = 0.00;
        costFE = 0.00;
        costFSE = 0.00;
        costFT = 0.00;
        costInvA = 0.00;
        costTotal = 0.00;
    }
    
    //Metodos setters

    public void setQ(int q) {
        this.q = q;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setCostComp(double costComp) {
        this.costComp = costComp;
    }

    public void setCostInv(double costInv) {
        this.costInv = costInv;
    }

    public void setCostOrden(double costOrden) {
        this.costOrden = costOrden;
    }

    public void setCostFE(double costFE) {
        this.costFE = costFE;
    }

    public void setCostFSE(double costFSE) {
        this.costFSE = costFSE;
    }

    public void setCostFT(double costFT) {
        this.costFT = costFT;
    }

    public void setCostInvA(double costInvA) {
        this.costInvA = costInvA;
    }

    public void setCostTotal(double costTotal) {
        this.costTotal = costTotal;
    }
   
    //Metodos getters

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    public double getCostComp() {
        return costComp;
    }

    public double getCostInv() {
        return costInv;
    }

    public double getCostOrden() {
        return costOrden;
    }

    public double getCostFE() {
        return costFE;
    }

    public double getCostFSE() {
        return costFSE;
    }

    public double getCostFT() {
        return costFT;
    }

    public double getCostInvA() {
        return costInvA;
    }

    public double getCostTotal() {
        return costTotal;
    }
   
   public void mostrarCostos(){
       DecimalFormat f = new DecimalFormat("###.##");
       System.out.println("Q: " + q + "\t\tR: " + r + "\nCosto de inventario: " + f.format(costInv) + "\nCosto de Orden: " +
               f.format(costOrden) + "\nCosto de Compra: " + f.format(costComp) + "\nCosto faltante: " + f.format(costFT) 
               + "\nCosto Total: " + f.format(costTotal));
             
   }
    
    
    
    
    
}
