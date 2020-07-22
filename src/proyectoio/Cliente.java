
package proyectoio;

/**
 *
 * @author Kharen
 */
public class Cliente {
    private int tiempEsp;
    private int demanda;
    
    //Constructor sin parametros
    public Cliente(int tiempEsp, int demanda){
        this.tiempEsp = tiempEsp;
        this.demanda = demanda;
    }
    //Metodos setters

    public void setTiempEsp(int tiempEsp) {
        this.tiempEsp = tiempEsp;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }
    //Metodos getters

    public int getTiempEsp() {
        return tiempEsp;
    }

    public int getDemanda() {
        return demanda;
    }
    
    
}
