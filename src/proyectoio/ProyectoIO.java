/*--------------------------------------------------------*/
/*           Universidad Católica Andrés Bello            */
/*                Facultad de Ingenieria                  */
/*            Escuela de Ingenieria Informática           */
/*          Asignatura: Investigación de Operaciones      */
/*                 Prof. Ing. Luz Medina C.               */
/*   Realizado por: Kharen Urdaneta      CI:V-27.923.856  */
/*                  Gabriela Albornoz    CI:V-25.083.768  */
/*--------------------------------------------------------*/

package proyectoio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Queue;


/**
 *
 * @author Kharen
 */
public class ProyectoIO {
    enum Tiempo{
        DIAS,SEMANAS , MESES, BIMESTRES, TRIMESTRES;
    }
/*------------------------SE ENCARGA DE REALZAR LA SIMULACION DEL MODELO POR UN TIEMPO DADO POR EL USUARIO--------------------------*/
    public static void simularModelo(List<Rango> demandas, List<Rango> tEntrega, List<Rango> tEspera, List<Costos> costosT,
            Queue<Compra> qComprasP, Queue<Orden> qOrdenP, Costos costos,int tiempo, int q, int r, int invIn, int i , 
            double costoOrden, int numOrden, double costoInv, double costoComp, double costoFE, double costoFSE, Tiempo etiqueta){
       
        int  orden = -1, tEsp = 0, deman = 0, tEnt = 0, flag = 0, falt = 0;
       Inventario inventario = new Inventario();
       Compra compra; Cliente cliente; Orden norden;

        if (tiempo == 0){
            return;
        }
        inventario.setTiempo(tiempo); 
        orden = verificarColaOrdenes(qOrdenP); //Verifica si hay ordenes pendientes
        falt = verificarColaComprasPendientes(qComprasP); // Verifica si existen pedidos pendientes

        if (falt == 1 || falt == 0){ //En caso de haber compras pendientes se actualizan todos sus tiempos de espera en la cola
            for(Compra cola : qComprasP ){
                cola.getCliente().setTiempEsp(cola.getCliente().getTiempEsp()-1);
            }
        }
        if (orden == 1 ){ //Si llego una nueva orden se abastece el inventario tomando en cuenta a Q
            abastecerInventario(inventario, invIn + q, qComprasP, costos);
            orden = -1; //Se establece que esa orden fue satisfecha
        } 
        else { //Sino llego nueva orden se abastece segun el inventario actual
            abastecerInventario(inventario, invIn, qComprasP, costos);  
        }   
        //Se generan los numeros aleatorios correspondientes a la demanda
        deman = numerosAleatorios(demandas);

        if ( deman > inventario.getInvInicial()){ //Si la demanda es mayor que el inventario actual 
            inventario.setFaltantes(deman - inventario.getInvInicial()); //Se anaden faltantes 
            inventario.setInvFinal(0); //Se satisface todo lo que se pueda
              tEsp = numerosAleatorios(tEspera); //Se genera unnumero aleatorio para saber si el cliente desea esperar
              
            if (tEsp > 0){ //Si el cliente desea esperar
                cliente = new Cliente(tEsp, deman);
                compra = new Compra(inventario.getInvInicial(), inventario.getFaltantes(),tiempo,  cliente ); 
                qComprasP.add(compra); //Se anade su compra a la cola de compras pendientes por satisfacer
            }
            else{
                costos.setCostFSE(costos.getCostFSE() + inventario.getFaltantes()); //Si el cliente no desea esperar se anade el costo perdido
            }
        }
        else{
            if (deman <= inventario.getInvInicial()){ //Si la demanda es mayor o igual  que el inventario actual
                inventario.setInvFinal(inventario.getInvInicial()- deman); //Se satisface la demanda y se actualiza el inventario final
                
            }
        }//Si no hay ordenes pendientes y el inventario final es menor al punto de reorden se pide una nueva orden
        if (inventario.getInvFinal() <= r && orden == -1){ 
                tEnt = numerosAleatorios(tEntrega); //Se genera un numero aleatorio para sabercuanto se debe esperar por su entrea
                numOrden++; //Se actualiza el numero de ordenes realizadas
                norden = new Orden(costoOrden, q,tEnt, numOrden ); 
                qOrdenP.add(norden);                //Se anade a la cola de ordenes
                costos.setCostOrden(numOrden); //Se anade el numero de orden a el costo por orden total
                costos.setCostComp(numOrden);//Se anade el numero de orden a el costo por compra total
                }
        inventario.setInvProm((double)(inventario.getInvInicial()+inventario.getInvFinal())/2);   
        costos.setCostInv(costos.getCostInv() + inventario.getInvProm()); 
        tiempo--;  //Se actualiza el tiempo de simulacion
       
        simularModelo(demandas, tEntrega, tEspera, costosT, qComprasP, qOrdenP,costos, tiempo, q, r, inventario.getInvFinal(), 
                i , costoOrden, numOrden, costoInv, costoComp, costoFE, costoFSE, etiqueta);   
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/

    /*---------------------DEVUELVE EL TIEMPO CORRESPONDIENTE EN ANOS PARA REALIZAR LAS CONVERSIONES DE UNIDADES NECESARIAS---------------*/
  public static int convertirUnidades (Tiempo etiqueta){
    int uni = 1;
           switch (etiqueta) {
            case DIAS:{
                uni = 360;
                return uni;    
            }
            case SEMANAS:{
                uni = 52;
                return uni;
            }
            case MESES:{
                uni = 12;
                return uni;
            }
            case BIMESTRES:{
                uni = 6;
                return uni;
            }
            case TRIMESTRES:{
                uni = 4;
                return uni;
            }
           }
return uni;}
/*-------------------------------------------------------------------------------------------------------------------------------------*/
  
  
/*---------------------SE ENCARGA DE CALCULAR LOS COSTOS TOTALES AL FINALIZAR LA SIMULACION-------------------------------------------*/
    public static void actualizarCostos( Costos costos, int q, int r, double costoInv, double costoComp, double costoOrd,
            double costoFE, double costoFSE, Tiempo etiqueta ){
       
        int uni;
       
        uni = convertirUnidades(etiqueta);
        /*---------------Se realizan los calculos correspondientes a cada costo----------------------------------------*/
        costos.setCostComp(costos.getCostComp()*costoComp*q);
        costos.setCostOrden(costos.getCostOrden()*costoOrd);
        costos.setCostFE(costos.getCostFE()*costoFE);
        costos.setCostFSE(costos.getCostFSE()*costoFSE);
        costos.setCostFT(costos.getCostFE() + costos.getCostFSE());
        costos.setCostInvA(costoInv);
        costos.setCostInv(costos.getCostInv()*((double)costos.getCostInvA()/uni));
        costos.setCostTotal(costos.getCostComp() + costos.getCostOrden() + costos.getCostFT() + costos.getCostInv());
      /*----------------------------------------------------------------------------------------------------------------*/  
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/
 /*-----------------SE ENCARGA DE SATISFACER LA DEMANDA DE CLIENTE DEPENDIENDO DEL INVENTARIO QUE SE DISPONGA----------------------
                        Y ANADIR LOS COSTOS CORRRESPONDIENTES SEGUN SEA EL CASO A COSTOS TOTALES*/
    public static  void cubrirDemandaF(Inventario inventario,  Queue<Compra> qComprasP, Costos costos){
     
        if(inventario.getInvInicial() >= qComprasP.element().getUniFalt()){
          inventario.setInvInicial(inventario.getInvInicial()- qComprasP.element().getUniFalt()) ;
          costos.setCostFE(costos.getCostFE() + qComprasP.element().getUniFalt()); 
          qComprasP.remove(); //Se elimina de la cola de ordenes
          return;
        }

        qComprasP.element().setUniFalt(qComprasP.element().getUniFalt()-inventario.getInvInicial());
        costos.setCostFE(costos.getCostFE() + inventario.getInvInicial());
        qComprasP.element().setUniVend(qComprasP.element().getUniVend()+ inventario.getInvInicial());
        inventario.setInvInicial(0);   
    }
 /*----------------------------------------------------------------------------------------------------------------------------------*/
    
    
 /*------------SE ENCARGA DE VERIFICAR SI EXISTEN COMPRAS PENDIENTES EN LA COLA DE COMPRAS-------------------------------------------*/
    public static int  verificarColaComprasPendientes(Queue<Compra> qComprasP){
        if (qComprasP.isEmpty()){//Si la cola esta vacia significa que no hay compras pendientes, devuelve -1
            return -1;
        }
        
        /*-if (qComprasP.element().getCliente().getTiempEsp() == 0){
            return 1;
        }-*/
    return 1;
    }
 /*----------------------------------------------------------------------------------------------------------------------------------*/
  
 /*---------------SE ENCARGA DE VERIFICAR SI HAY ORDEN EN ESPERA, EN CASO AFIRMATIVO ACTUALIZA EL TIEMPO DE ESPERA.
                         TAMBIEN INDICA SI YA ES MOMENTO DE LA ENTREGA DE DICHA ORDEN-------------------------------------------*/
    public static int verificarColaOrdenes(Queue<Orden> qOrdenP){
        if ( qOrdenP.isEmpty() ){ //Si la cola esta vacia  no hay ordenes en espera devuelve -1
            return -1;
        }
        //Si hay ordenes en espera actualiza su tiempo de entrega
        qOrdenP.element().setTiempEnt(qOrdenP.element().getTiempEnt() - 1); 
        //Si el tiempo de entrega llego a -1 significa que ya es momento de la llegada de la orden devuelve 1
        if (qOrdenP.element().getTiempEnt() == -1){
            qOrdenP.remove(); // Y eliminas la orden
           return 1; 
        }
    //Retorna 0 en caso de no ser momento de llegada
    return 0;}
/*-----------------------------------------------------------------------------------------------------------------------------------*/
 
    /*---------SE ENCARGA DE ABASTECER EL INVENTARIO SEGUN LAS CONDICIONES PRESENTADAS EN CADA ITERACION DE LA SIMULACION------------*/
    public static void abastecerInventario(Inventario inventario, int invIn, Queue<Compra> qComprasP, Costos costos){
        int falt;

        inventario.setInvInicial(invIn); //Establece el inventario incial
     
         falt = verificarColaComprasPendientes(qComprasP); //Verifica si hay compras pendientes para ver si puede satisfacerlas
         if (falt == -1 ){ //Si no hay compras pendientes sigue su curso normal
            return;
        } 
        if( invIn == 0 ){       //Si hay compras pendientes pero no dispone de iventario para satisfacer sigue su curso normal     
            return ;
        }
        //Si hay compras pendientes y se dispone de inventario para satisfacerla , entonces verifica si el ya
        //tiempo del cliente expiro
        if(qComprasP.element().getCliente().getTiempEsp() < 0){ //En caso de que haya expirado
            costos.setCostFSE(costos.getCostFSE() + qComprasP.element().getUniFalt());//Anade el costo a la lista de faltantes sin espera
            qComprasP.remove(); //Elimina la compra de la cola de pendientes
        }
        else {//En caso de que no haya expirado se cubre la demanda
           cubrirDemandaF(inventario,qComprasP, costos); 
        }
       //Se verifica nuevamente si aun se dispone de compras por abastecer y si se dispone del inventario para hacerlo
       abastecerInventario(inventario, inventario.getInvInicial(), qComprasP, costos);
    }
   /*---------------------------------------------------------------------------------------------------------------------------------*/
    
  /*----------------------SE ENCARGA DE CALCULAR EL VALOR DE Q Y DEVOLVERLO-----------------------------------------------------------*/
   public static int calcularQ( int d,  double h, double k, double s, Tiempo etiqueta){
       
       double q = 0;
       int uni = 1;
       uni = convertirUnidades(etiqueta);
       q = Math.sqrt((2*k*d*uni*(h+s))/(h*s));
   return (int) q;} 
   /*--------------------------------------------------------------------------------------------------------------------------------*/
   
  /*-------------------SE ENCARGA DE ESTABLECER EL INTERVALO CORRESPONDIENTE A LAS Qs(Qmin y Qmax) ----------------------------------*/
  public static Rango establecerIntervalosQs(int dMin, int dMax, double h, double k, double sMin, double sMax, Tiempo etiqueta){
      int qMin, qMax;
      Rango rango;
      
      qMin = calcularQ(dMin, h, k, sMin, etiqueta);
      qMax = calcularQ(dMax, h, k , sMax, etiqueta);
      
 return rango = new Rango(qMin, qMax, 0); }
  /*---------------------------------------------------------------------------------------------------------------------------------*/
  
  /*----------------------SE ENCARGA DE CALCULAR EL VALOR DEL PUNTO DE REORDEN (R) Y DEVOLVERLO--------------------------------------*/
   public static int calcularR( int tE, int d,  int q, Tiempo etiqueta){
   
       double r, to, le;
       int uni = 1 ;
       
      
      //Se convierten las unidades anos segun haya sido la eleccion del usuario
       uni = convertirUnidades(etiqueta);
       to = (double) q/(d*uni);
       d = d*uni;
       
      if (tE <= to){
          
        r = ((double) (tE)/uni) *d;
      }
      else{
          System.out.println("Si es tE mayor");
        le = (double) tE/uni - ((int)((double)tE/uni)/to)* (double) to;  //Se calcula el tiempo de entrega efectivo en caso se que L>to
        r = (double) le *d;
      }
  return (int) r;    
 }
   /*-----------------------ESTABLECE EL INTERVALO CORRESPONDIENTE A LAS Rs (Rmin y Rmax)--------------------------------------------*/
 public static Rango establecerIntervaloRs(int tEMin, int tEMax, int dMin, int dMax, int qMin, int qMax, Tiempo  etiqueta){
    
     int rMin, rMax;
     Rango rango;
     rMin = calcularR(tEMin, dMin,qMin, etiqueta);
     rMax = calcularR(tEMax, dMax,qMax, etiqueta);
     
 return rango = new Rango (rMin, rMax, 0);}
 /*----------------------------------------------------------------------------------------------------------------------------------*/

 /*--------------------DETERMINA  EL VALOR MINIMO DE UNA LISTA TIPO RANGO--------------------------------------------*/
 public static int  determinarMin(List <Rango> lista){
     int min =  lista.get(0).getValor();
     
     for (Rango l:lista){
         if (min > l.getValor()){
             min = l.getValor();
         }
     }
     
 return min;}
 /*---------------------DETERMINA EL VALOR MAXIMO DE UNA LISTA TIPO RANGO-----------------------------------------------------------*/
 public static int determinarMax(List <Rango> lista){
     int max = lista.get(0).getValor();
     
     for(Rango l:lista){
         if (max < l.getValor()){
             max = l.getValor();  
        }
     }
 return max;}
 
 /*-----------------------------------------------------------------------------------------------------------------------------------*/
 
 /*-------------------------GENERA UN NUMERO ALEATORIO Y UBICA SU VALOR SEGUN SU INTERVALO DE PROBABILIDAD---------------------------*/
    public static int numerosAleatorios(List <Rango> lista){
        Random r = new Random();
        int num = r.nextInt(100);
        DecimalFormat f = new DecimalFormat("##.##");
        
        for ( int i = 0; i < lista.size(); i++){
            if (i == 0 ){
                if ( lista.get(0).getMinimo() <= (double)num/100 && lista.get(0).getMaximo() >= (double) num/100){
                    return lista.get(0).getValor();
                }
            }
            if ((lista.get(i).getMinimo() < (double)num/100) &&  (lista.get(i).getMaximo() >= (double) num/100)){
                return lista.get(i).getValor();
                
             }
        }        
    return -1;}
 /*----------------------------------------------------------------------------------------------------------------------------------*/
 
 /*----------ALMACENA LAS PROBABILIDADES DADAS POR EL USUARIO EN UNA LISTA, EN CASO DE DARLAS EN PORCENTAJE LAS TRANSFORMA-----------*/
    public static void almacenarProbabilidades(List <Rango> lista, double min,int flag ){
        Scanner input = new Scanner(System.in);

        int deman = 0;
        double prob = 0.00;
        
        if (flag == 0){
            return;
        }
        if(input.hasNext() && !input.hasNextInt() ){
            input.nextLine();
        }
        else {
            deman = input.nextInt();
        }
        if(input.hasNext()&& !input.hasNextDouble() ){
            input.nextLine();
        }
        if (input.hasNext() &&  input.hasNextDouble()){
            prob = input.nextDouble();
        }
        
        if (prob > 1){ //Si la probabilidad es dada en porcentaje se transforma a decimal
          prob = (double) prob/100;
        }
        Rango rango = new Rango(min, prob + min,deman );
        lista.add(rango);
        
        if (flag == 1){
            System.out.println("¿Desea agregar otro dato? Si[1]/No[0]");
            if ( input.hasNext() && !input.hasNextInt()){
                input.nextLine();
            }
            flag = input.nextInt(); 
            
            while(flag != 1 && flag != 0){
                System.out.println("La opcion ingresada no se encuentra disponible. Marque [1]/[0]");
                flag = input.nextInt();
             }
            if ( flag == 1 && lista.get(lista.size() - 1).getMaximo() == 1){
                System.out.println("La suma de todas sus probabilidades no debe exceder de uno");
                return;    
            }       
        }
        System.out.println();
        almacenarProbabilidades(lista, prob + min, flag);        
    }
    /*--------------------------------------------------------------------------------------------------------------------------------*/
 /*---------------------------------ESTABLECE LAS ETIQUETAS CORRESPONDIENTES AL TIEMPO EN LA UNIDAD SELECCIONADA----------------------*/   
    public static Tiempo enviarEtiquetas (int opcion){
        switch (opcion){
            case 1: {
                return Tiempo.DIAS;
            }
            case 2:{
                return Tiempo.SEMANAS;
            }
            case 3:{
                return Tiempo.MESES;
            }
            case 4:{
                return Tiempo.BIMESTRES;
            }  
            case 5:{
                return Tiempo.TRIMESTRES;
            }
    }
   return Tiempo.DIAS;}
/*------------------------------------------------------------------------------------------------------------------------------------*/ 
 
/*--------SE ENCARGA DE DETERMINAR LA POLITICA OPTIMA ENTRE TODAS LAS RESULTANTES DE LAS VARIACIONES Q Y R----------------------------*/
    public static Costos determinarPoliticaOptima(List<Costos> costosL){
        Costos pOpti = costosL.get(0);
        
        for(Costos c: costosL){
           if( pOpti.getCostTotal() > c.getCostTotal() ) {
               pOpti = c;
           }
                
        }
 return pOpti;  }
/*------------------------------------------------------------------------------------------------------------------------------------*/
    
/*---------------------------SE ENCARGA DE ARCHIVAR LOS DATOS DATOS POR EL USUARIO---------------------------------------------------*/
 public static void archivarDatosEntrada(int tiempoS , List<Rango> demandas, List<Rango> tEntrega, List<Rango> tEspera, double costoInv, 
         double costoComp, double costoOrd, double costoFE, double costoFSE, int invIn, String nombreArchivo) throws IOException{
     
     String ruta = "C:\\Users\\Kharen\\Documents\\6to Semestre\\Investigacion de Operaciones\\Proyecto\\"+nombreArchivo;
     File archivo = new File(ruta);
     FileWriter fw = null;
     BufferedWriter bw = null;
     try{
        if (!archivo.exists()){
            archivo.createNewFile();
        }
        fw = new FileWriter(archivo.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write("DEMANDAS             PROBABILIDADES\n");
         for (Rango r1: demandas){
             bw.write(String.valueOf(r1.getValor()) + "\t\t\t");
             bw.write(String.valueOf(r1.getMaximo() - r1.getMinimo()) + "\n");
         }
        bw.write("TIEMPOS DE ENTREGA     PROBABILIDADES\n");
         for (Rango r2: tEntrega){
             bw.write(String.valueOf(r2.getValor()) + "\t\t\t");  
             bw.write(String.valueOf(r2.getMaximo() - r2.getMinimo()) + "\n");           
         }
         bw.write("TIEMPOS DE ESPERA    PROBABILIDADES\n");
         for (Rango r3: tEspera){
             bw.write(String.valueOf(r3.getValor())  + "\t\t\t");
             bw.write(String.valueOf(r3.getMaximo() - r3.getMinimo()) + "\n");               
         }
         bw.write("\tDATOS\n");
         bw.write("Tiempo de simulacion: " + String.valueOf(tiempoS)  + "\n");
         bw.write("Costo de inventario: " + String.valueOf(costoInv) + "[$/unidad]\n");
         bw.write("Costo de compra: " + String.valueOf(costoComp)+ "[$/unidad]\n");
         bw.write("Costo de orden: " + String.valueOf(costoOrd) + "[$/orden]\n" );
         bw.write("Costo faltante con espera: " + String.valueOf(costoFE)  + "[$/unidad]\n");
         bw.write("Costo faltante sin espera: " +String.valueOf(costoFSE) + "[$/unidad]\n" );
         bw.write("Inventario inicial: "+ String.valueOf(invIn)     + "[unidades]\n");
     }
     catch (IOException e){
     }
     finally{
         try{ 
             if(bw != null){
                 bw.close();
             }
             if(fw != null){
                 fw.close();
             }
         }
         catch (IOException ex){
         }   
    }
 }   

 /*------------------SE ENCARGA DE ARCHIVAR LOS RESULTADOS OBTENIDOS DE CADA VARIACION DE Q Y R----------------------------------------*/
public static void archivarPoliticaOptima(Costos c, String nombreArchivo){
         
String ruta = "C:\\Users\\Kharen\\Documents\\6to Semestre\\Investigacion de Operaciones\\Proyecto\\"+nombreArchivo;
     File archivo = new File(ruta);
     FileWriter fw = null;
     BufferedWriter bw = null;
     try{
        if (!archivo.exists()){
            archivo.createNewFile();
        }
        fw = new FileWriter(archivo.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write("\nPOLITICA OPTIMA\n");

        bw.write("Q: " + String.valueOf(c.getQ()) + "[unidades]\t\tR: " + String.valueOf(c.getR()) + "[unidades]\n");
        bw.write("Costo de inventario anual: " + String.valueOf(c.getCostInvA()) + "[$/año]");
        bw.write("Costo de orden: " + c.getCostOrden() + "[$]");
        bw.write("Costo de compra: " + c.getCostComp() + "[$]");
        bw.write("Costo faltante con espera de cliente: " + c.getCostFE() + "[$]");
        bw.write("Costo faltante sin espera del cliente: " + c.getCostFSE() + "[$]" );
        bw.write("Costo faltante total: " + c.getCostTotal() + "[$]");
        bw.write("Costo Total: " + c.getCostTotal() + c.getCostTotal() + "[$]");
     }
     catch (IOException e){
     }
     finally{
         try{ 
             if(bw != null){
                 bw.close();
             }
             if(fw != null){
                 fw.close();
             }
         }
         catch (IOException ex){
         }   
    }
 }   
 /*------------------------------------------------------------------------------------------------------------------------------------*/    
    public static void main(String[] args) throws IOException {
        List <Rango> demandas = new ArrayList <>();
        List <Rango> tEntrega = new ArrayList <>();
        List <Rango> tEspera = new ArrayList <>();
        List<Costos> costosT = new ArrayList<>();
        Queue<Orden> qOrdenP = new LinkedList();
        Queue<Compra> qComprasP = new LinkedList();
        List <Costos> costosL = new ArrayList<>();
        Costos pOptima = null;
        Rango qs = null, rs = null;
        String nombreArchivo = "";
        double costoInv = 0.00, costoComp = 0.00, costoOrd = 0.00, costoFE = 0.00,costoFSE  = 0.00;
        int opcion, tiempoS, num, invIn, dmin, dmax, tEmin, tEmax = 0, qmin, qmax, rmin, rmax, q ,r;
        Scanner input = new Scanner(System.in);
        Tiempo etiqueta;
        
        System.out.print("\t\t\tSIMULADOR\nTiempo de simulacion: ");
        tiempoS = input.nextInt();
        System.out.println("Unidades de tiempo:\n[1]Dias\n[2]Semanas\n[3]Meses\n[4]Bimestres\n[5]Trimestres");
        opcion = input.nextInt();
        etiqueta = enviarEtiquetas(opcion);
        System.out.println("Ingrese las demandas con sus respectivas probabilidades");
        almacenarProbabilidades(demandas, 0.00, 1);
        System.out.println("Ingrese los tiempos de entrega con sus respectivas probabilidades");
        almacenarProbabilidades(tEntrega, 0.00, 1);
        System.out.println("Ingrese los tiempos de espera con sus respectivas probabilidades");
        almacenarProbabilidades(tEspera, 0.00, 1);
       
        System.out.print("\nCosto de inventario[$/unidad/año]: ");
        if (input.hasNext() && !input.hasNextDouble()){
            input.nextLine();
        }
        costoInv = input.nextDouble();
        
        System.out.print("\nCosto de compra[$/unidad]: ");
        if (input.hasNext() && !input.hasNextDouble()){
            input.nextLine();
        }
        costoComp = input.nextDouble();
        
        System.out.print("\nCosto de orden[$/orden]: ");
        if (input.hasNext() && !input.hasNextDouble()){
            input.nextLine();
        }
        costoOrd = input.nextDouble();       
        
        System.out.print("\nCosto faltante con espera[$/unidad]: ");
        if (input.hasNext() && !input.hasNextDouble()){
            input.nextLine();
        }
        costoFE = input.nextDouble();
        System.out.print("\nCosto faltante sin espera[$/unidad]: ");
        if (input.hasNext() && !input.hasNextDouble()){
            input.nextLine();
        }
        costoFSE = input.nextDouble();   
        System.out.print("\nInventario Inicial[unidades]: ");
        if (input.hasNext() && !input.hasNextInt()){
            input.nextLine();
        } 
        invIn = input.nextInt();
        System.out.println("¿Desea archivar sus datos de entrada? Si[1]/No[0]");
        if (input.hasNext() && !input.hasNextInt()){
            input.nextLine();
        } 
        do{
            opcion = input.nextInt();
            if (opcion != 1 && opcion != 0){
                System.out.print("La opcion ingresada no se encuentra disponible ");
            }
        }
        while(opcion != 1 && opcion != 0);
        
        if (opcion == 1){
            System.out.print("Nombre del archivo: ");
            nombreArchivo = input.next();          
        } 
        archivarDatosEntrada(tiempoS, demandas, tEntrega, tEspera, costoInv, costoComp, costoOrd, costoFE, costoFSE, invIn, nombreArchivo);
        dmin = determinarMin(demandas);
        dmax = determinarMax(demandas);
        tEmin = determinarMin(tEntrega);
        tEmax = determinarMax(tEntrega);
        //System.out.println("Demanda minima: " + dmin + "\nDemanda maxima: " + dmax + "\ntiempo entrega minimo: " + tEmin + " Tiempo entrega maximo: " + tEmax);
        qmin = calcularQ(dmin, costoInv, costoOrd, costoFSE, etiqueta);
        qmax = calcularQ(dmax, costoInv, costoOrd, costoFE, etiqueta);
        rmin = calcularR(tEmin, dmin, qmin, etiqueta);
        rmax = calcularR(tEmax, dmax, qmax, etiqueta);
        //System.out.println("qmin: " + qmin + "\nqmax: " + qmax + "\nrmin: " + rmin + " rmax: " + rmax);

        /*-----------SIMULACION CON VARIACIONES DE Q Y R-----------------------------------------------------------------------*/
       for (  q = qmin; q <= qmax ; q++){
            for ( r = rmin; r <= rmax; r++ ){
                Costos costos = new Costos();
                costos.setQ(q);
                costos.setR(r);
                simularModelo(demandas, tEntrega, tEspera, costosT, qComprasP, qOrdenP,costos, tiempoS, q, r, 10, 
                    0 , costoOrd, 0, costoInv, costoComp, costoFE, costoFSE, enviarEtiquetas(opcion) );   
                if (!qComprasP.isEmpty()){
                    qComprasP.clear();
                }
                if(!qOrdenP.isEmpty()){
                qOrdenP.clear();   
                }
                actualizarCostos(costos,q, r, costoInv,costoComp, costoOrd,costoFE,  costoFSE, enviarEtiquetas(opcion) );
                costos.mostrarCostos();
                costosL.add(costos);
            }
        }
        System.out.println("--------POLITICA OPTIMA-----------");
        pOptima = determinarPoliticaOptima(costosL);
        pOptima.mostrarCostos();
        System.out.println("-----------------------------------");
        archivarPoliticaOptima(pOptima, nombreArchivo);
      /*-------------------------------------------------------------------------------------------------------------------------*/
    }          
}
