
package Ventanas;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kharen y Gabriela
 */
public class Ventana2 extends javax.swing.JFrame {
    DefaultTableModel modeloD;
    DefaultTableModel modeloTEn;
    DefaultTableModel modeloTEsp;
    public static ArrayList <Costos> costosL = new ArrayList<>();
    public static Costos pOptima = null;
    
    public Ventana2() {
        initComponents();
        this.setLocationRelativeTo(null);
        modeloD = (DefaultTableModel) tablaDemandas.getModel();
        modeloTEn = (DefaultTableModel) tablaTEntrega.getModel();
        modeloTEsp = (DefaultTableModel) tablaTEspera.getModel();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        etiqueta1 = new javax.swing.JLabel();
        cajaProbDeman = new javax.swing.JTextField();
        cajaProbTEN = new javax.swing.JTextField();
        etiqueta2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDemandas = new javax.swing.JTable();
        botonElim2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cajaTEN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cajaDemanda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTEspera = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTEntrega = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cajaTESP = new javax.swing.JTextField();
        cajaProbTESP = new javax.swing.JTextField();
        botonElim3 = new javax.swing.JButton();
        botonIns2 = new javax.swing.JButton();
        botonIns3 = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonElim1 = new javax.swing.JButton();
        botonIns1 = new javax.swing.JButton();
        botonEjec = new javax.swing.JButton();
        etiqueta10 = new javax.swing.JLabel();
        rboton2 = new javax.swing.JRadioButton();
        rboton1 = new javax.swing.JRadioButton();
        etiqueta8 = new javax.swing.JLabel();
        cajaNombArch = new javax.swing.JTextField();
        botonAtras = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Fondo2 = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta1.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta1.setText("Probabilidad:");
        getContentPane().add(etiqueta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, 30));

        cajaProbDeman.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaProbDeman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaProbDemanActionPerformed(evt);
            }
        });
        cajaProbDeman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaProbDemanKeyTyped(evt);
            }
        });
        getContentPane().add(cajaProbDeman, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 80, 30));

        cajaProbTEN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaProbTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaProbTENActionPerformed(evt);
            }
        });
        cajaProbTEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaProbTENKeyTyped(evt);
            }
        });
        getContentPane().add(cajaProbTEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 80, 30));

        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta2.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta2.setText("Demanda:");
        getContentPane().add(etiqueta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 90, 30));

        tablaDemandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Demanda", "Probabilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDemandas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 240, 90));

        botonElim2.setBackground(new java.awt.Color(255, 255, 255));
        botonElim2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonElim2.setText("Eliminar");
        botonElim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElim2ActionPerformed(evt);
            }
        });
        getContentPane().add(botonElim2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Probabiidad: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 140, -1));

        cajaTEN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaTEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTENActionPerformed(evt);
            }
        });
        cajaTEN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTENKeyTyped(evt);
            }
        });
        getContentPane().add(cajaTEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tiempo de Entrega: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 180, -1));

        cajaDemanda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDemandaKeyTyped(evt);
            }
        });
        getContentPane().add(cajaDemanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 80, 30));

        tablaTEspera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo de Espera", "Probabilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaTEspera);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 240, 90));

        tablaTEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo de Entrega", "Probabilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaTEntrega);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 240, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Probabilidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tiempo de Espera: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 30));

        cajaTESP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTESPKeyTyped(evt);
            }
        });
        getContentPane().add(cajaTESP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 80, 30));

        cajaProbTESP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaProbTESPKeyTyped(evt);
            }
        });
        getContentPane().add(cajaProbTESP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 80, 30));

        botonElim3.setBackground(new java.awt.Color(255, 255, 255));
        botonElim3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonElim3.setText("Eliminar");
        botonElim3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElim3ActionPerformed(evt);
            }
        });
        getContentPane().add(botonElim3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, 30));

        botonIns2.setBackground(new java.awt.Color(255, 255, 255));
        botonIns2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonIns2.setText("Insertar");
        botonIns2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIns2ActionPerformed(evt);
            }
        });
        getContentPane().add(botonIns2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, 30));

        botonIns3.setBackground(new java.awt.Color(255, 255, 255));
        botonIns3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonIns3.setText("Insertar");
        botonIns3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIns3ActionPerformed(evt);
            }
        });
        getContentPane().add(botonIns3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, 30));

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 600, 120, 40));

        botonElim1.setBackground(new java.awt.Color(255, 255, 255));
        botonElim1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonElim1.setText("Eliminar");
        botonElim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElim1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonElim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 30));

        botonIns1.setBackground(new java.awt.Color(255, 255, 255));
        botonIns1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonIns1.setText("Insertar");
        botonIns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIns1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonIns1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 30));

        botonEjec.setBackground(new java.awt.Color(255, 255, 255));
        botonEjec.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonEjec.setText("Ejecutar");
        botonEjec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecActionPerformed(evt);
            }
        });
        getContentPane().add(botonEjec, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 120, 40));

        etiqueta10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta10.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta10.setText("¿Desea Archivar los datos?");
        getContentPane().add(etiqueta10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 250, 30));

        buttonGroup1.add(rboton2);
        rboton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rboton2.setForeground(new java.awt.Color(255, 255, 255));
        rboton2.setText("No");
        rboton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboton2ActionPerformed(evt);
            }
        });
        getContentPane().add(rboton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 60, -1));

        buttonGroup1.add(rboton1);
        rboton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rboton1.setForeground(new java.awt.Color(255, 255, 255));
        rboton1.setText("Si");
        rboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboton1ActionPerformed(evt);
            }
        });
        getContentPane().add(rboton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 60, -1));

        etiqueta8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta8.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta8.setText("Nombre del archivo:");
        getContentPane().add(etiqueta8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, 20));

        cajaNombArch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaNombArch.setEnabled(false);
        cajaNombArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombArchActionPerformed(evt);
            }
        });
        getContentPane().add(cajaNombArch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 160, 30));

        botonAtras.setBackground(new java.awt.Color(255, 255, 255));
        botonAtras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonAtras.setText("Atrás");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(botonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 120, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Por favor, ingrese los datos solicitados a continuación, para dar inicio a su simulación");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        Fondo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Fondo2.setForeground(new java.awt.Color(255, 255, 255));
        Fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/image5.JPG"))); // NOI18N
        getContentPane().add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaProbDemanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaProbDemanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaProbDemanActionPerformed

    private void cajaProbTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaProbTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaProbTENActionPerformed

    private void botonElim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElim2ActionPerformed
 
        int fila = tablaTEntrega.getSelectedRow();
        if (fila >= 0){
            modeloTEn.removeRow(fila);     
        }
    }//GEN-LAST:event_botonElim2ActionPerformed

    private void cajaTENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTENActionPerformed

    private void botonElim3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElim3ActionPerformed
        int fila = tablaTEspera.getSelectedRow();
        if (fila >= 0){
            modeloTEsp.removeRow(fila);     
        }
    }//GEN-LAST:event_botonElim3ActionPerformed

    private void botonIns3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIns3ActionPerformed
        String[] tiempoEsp = new String[2];
        if (cajaTESP.getText().length() == 0 || cajaProbTESP.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "¡Alerta!: Ningún campo debe estar vacio al momento de insertar datos en la tabla");
            return;
        }
        tiempoEsp[0] = cajaTESP.getText();
        tiempoEsp[1] = cajaProbTESP.getText();
        modeloTEsp.addRow(tiempoEsp);
        
        cajaTESP.setText("");
        cajaProbTESP.setText("");
    }//GEN-LAST:event_botonIns3ActionPerformed

    private void botonIns2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIns2ActionPerformed
        String[] tiempoEn = new String[2];
        if (cajaTEN.getText().length() == 0 || cajaProbTEN.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "¡Alerta!: Ningún campo debe estar vacio al momento de insertar datos en la tabla");
            return;
        }       
        tiempoEn[0] = cajaTEN.getText();
        tiempoEn[1] = cajaProbTEN.getText();
        modeloTEn.addRow(tiempoEn);
        
        cajaTEN.setText("");
        cajaProbTEN.setText("");
    }//GEN-LAST:event_botonIns2ActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonElim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElim1ActionPerformed
        int fila = tablaDemandas.getSelectedRow();
        if (fila >= 0){
            modeloD.removeRow(fila);     
        }
    }//GEN-LAST:event_botonElim1ActionPerformed

   private Boolean validarTablas(){
     
        if( tablaDemandas.getRowCount()== 0){
             return false;
        }
        if(tablaTEntrega.getRowCount()== 0){
             return false;
        }       
        if(tablaTEspera.getRowCount()== 0){
             return false;
        } 
 
    return true;
    }
    
    
    private void botonIns1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIns1ActionPerformed
        String[] demanda = new String[2];
        
        if (cajaDemanda.getText().length() == 0 || cajaProbDeman.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "¡Alerta!: Ningún campo debe estar vacio al momento de insertar datos en la tabla");
            return;
        }
        demanda[0] = cajaDemanda.getText();
        demanda[1] = cajaProbDeman.getText();
        modeloD.addRow(demanda);
        
        cajaDemanda.setText("");
        cajaProbDeman.setText("");
        
        
    }//GEN-LAST:event_botonIns1ActionPerformed

    private void botonEjecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecActionPerformed
        ArrayList <Rango> demandas = new ArrayList <>();
        ArrayList <Rango> tEntrega = new ArrayList <>();
        ArrayList <Rango> tEspera = new ArrayList <>();
        ArrayList<Costos> costosT = new ArrayList<>();
        Queue<Orden> qOrdenP = new LinkedList();
        Queue<Compra> qComprasP = new LinkedList();

        Rango qs = null, rs = null;
        double min = 0.00, prob = 0.00;
        int   dmin = 0, dmax = 0, aux = 0, tEmin = 0, tEmax = 0, qmin = 0, qmax = 0 , rmin = 0 , rmax = 0, r = 0, q = 0;
        Boolean valido = true;
        Ventana1 v1 = new Ventana1();
        Ventana3 v3 = new Ventana3();
        String nombreArch = "";
        if ( validarTablas() == false){
            JOptionPane.showMessageDialog(null, "¡Alerta! : Ninguna tabla puede estar vacia.");
            return;
        }
        if (rboton1.isEnabled() && cajaNombArch.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "¡Alerta! : Debe ingresar el nombre del archivo.");
            return;
        }
        else { 
            if(rboton1.isEnabled() && cajaNombArch.getText().length() != 0 ){
                nombreArch = (String) cajaNombArch.getText();   
            }     
        }
        /*--------------ALMACENAMIENTO DE DEMANDAS CON SUS RESPECTIVAS PROBABILIDADES------------*/
        for(int i = 0; i < tablaDemandas.getRowCount(); i++){
            prob =  (double) Double.parseDouble((String) tablaDemandas.getValueAt(i ,1));
            if (prob > 1){ //Si la probabilidad es dada en porcentaje se transforma a decimal
                prob = (double) prob/100;
            }
            aux = (int) Integer.parseInt((String) tablaDemandas.getValueAt(i ,0));
            Rango rango = new Rango(min, prob + min,aux);
            demandas.add(rango);
            min = min + prob;    
        }
       /*----------------------------------------------------------------------------------------*/
       min = 0.00;
       
       /*---------ALMACENAMIENTO DE TIEMPOS DE ENTREGA CON SUS RESPECTIVAS PROBABILIDADES--------*/
        for(int i = 0; i < tablaTEntrega.getRowCount(); i++){
            prob =  (double) Double.parseDouble((String) tablaTEntrega.getValueAt(i ,1));
            if (prob > 1){ //Si la probabilidad es dada en porcentaje se transforma a decimal
                prob = (double) prob/100;
            }
            aux = (int) Integer.parseInt((String) tablaTEntrega.getValueAt(i ,0));
            Rango rango = new Rango(min, prob + min,aux );
            tEntrega.add(rango);
            min = min + prob;    
        }
       /*----------------------------------------------------------------------------------------*/
        min = 0.00;

       /*---------ALMACENAMIENTO DE TIEMPOS DE ESPERA CON SUS RESPECTIVAS PROBABILIDADES---------*/
        for(int i = 0; i < tablaTEspera.getRowCount(); i++){
            prob = (double) Double.parseDouble((String) tablaTEspera.getValueAt(i ,1));
            if (prob > 1){ //Si la probabilidad es dada en porcentaje se transforma a decimal
                prob = (double) prob/100;
            }
            aux = (int) Integer.parseInt((String) tablaTEspera.getValueAt(i ,0));
            Rango rango = new Rango(min, prob + min,aux );
            tEspera.add(rango);
            min = min + prob;    
        }
        /*----------------------------------------------------------------------------------------*/
        
        /*-----------------------------------------------------------------------------------------------------------------------*/
       System.out.println("tamano arrays 1:" +  demandas.size() + " 2: " + tEntrega.size() + " 3: " + tEspera.size());
        for(Rango d:demandas){
            System.out.println("Minimo: " + d.getMinimo() + "\nMaximo: " + d.getMaximo() + "\nDemanda: " + d.getValor());
        }
        for(Rango te:tEntrega){
            System.out.println("Minimo: " + te.getMinimo() + "\nMaximo: " + te.getMaximo() + "\nTiempo de entrega: " + te.getValor());
        }
        for(Rango tes:tEspera){
            System.out.println("Minimo: " + tes.getMinimo() + "\nMaximo: " + tes.getMaximo() + "\nTiempo de espera: " + tes.getValor());
        }             
        /*---------------------------------------------------------------------------------------*/

        dmin = Principal.determinarMin(demandas);
        dmax = Principal.determinarMax(demandas);
        tEmin = Principal.determinarMin(tEntrega);
        tEmax = Principal.determinarMax(tEntrega);
        qmin = Principal.calcularQ(dmin, v1.costoInv, v1.costoOrden, v1.costoFSE, v1.etiqueta);
        qmax = Principal.calcularQ(dmax, v1.costoInv, v1.costoOrden, v1.costoFE, v1.etiqueta);
        rmin = Principal.calcularR(tEmin, dmin, qmin, v1.etiqueta);
        rmax = Principal.calcularR(tEmax, dmax, qmax, v1.etiqueta);

        /*-----------SIMULACION CON VARIACIONES DE Q Y R-----------------------------------------------------------------------*/
       for (  q = qmin; q <= qmax ; q++){
            for ( r = rmin; r <= rmax; r++ ){
                Costos costos = new Costos();
                costos.setQ(q);
                costos.setR(r);
                Principal.simularModelo(demandas, tEntrega, tEspera, costosT, qComprasP, qOrdenP,costos, v1.tiempoS, q, r, v1.invIn,
                    0 , v1.costoOrden, 0, v1.costoInv, v1.costoComp, v1.costoFE, v1.costoFSE, v1.etiqueta );
                if (!qComprasP.isEmpty()){
                    qComprasP.clear();
                }
                if(!qOrdenP.isEmpty()){
                    qOrdenP.clear();
                }
                Principal.actualizarCostos(costos,q, r, v1.costoInv, v1.costoComp, v1.costoOrden, v1.costoFE,  v1.costoFSE, v1.etiqueta );
                //costos.mostrarCostos();
                costosL.add(costos);
            }
        }
      
       
       v3.cargaAutomatica();
       v3.setVisible(true);
       this.setVisible(false);
       
        pOptima = Principal.determinarPoliticaOptima(costosL);
        pOptima.mostrarCostos();

        if (rboton1.isEnabled()){
            try {
                Principal.archivarDatosEntrada(v1.tiempoS, demandas, tEntrega, tEspera, v1.costoInv, v1.costoComp, v1.costoOrden,
                        v1.costoFE, v1.costoFSE, v1.invIn, nombreArch);
            } catch (IOException ex) {
                Logger.getLogger(Ventana2.class.getName()).log(Level.SEVERE, null, ex);
            }
            Principal.archivarPoliticaOptima(pOptima, nombreArch);

        }
        
        
        
    }//GEN-LAST:event_botonEjecActionPerformed

    private void rboton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboton2ActionPerformed
        cajaNombArch.setEnabled(false);

    }//GEN-LAST:event_rboton2ActionPerformed

    private void rboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboton1ActionPerformed
        cajaNombArch.setEnabled(true);
    }//GEN-LAST:event_rboton1ActionPerformed

    private void cajaNombArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombArchActionPerformed

    }//GEN-LAST:event_cajaNombArchActionPerformed

    private void cajaDemandaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDemandaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_cajaDemandaKeyTyped

    private void cajaProbDemanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaProbDemanKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaProbDeman.getText().contains(".")) ) {
            evt.consume();
}
    }//GEN-LAST:event_cajaProbDemanKeyTyped

    private void cajaTENKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTENKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_cajaTENKeyTyped

    private void cajaProbTENKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaProbTENKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaProbDeman.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaProbTENKeyTyped

    private void cajaTESPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTESPKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_cajaTESPKeyTyped

    private void cajaProbTESPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaProbTESPKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaProbDeman.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaProbTESPKeyTyped

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        this.setVisible(false);//REVISAR COMO VOLVER ATRAS
        
    }//GEN-LAST:event_botonAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main (String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo2;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEjec;
    private javax.swing.JButton botonElim1;
    private javax.swing.JButton botonElim2;
    private javax.swing.JButton botonElim3;
    private javax.swing.JButton botonIns1;
    private javax.swing.JButton botonIns2;
    private javax.swing.JButton botonIns3;
    private javax.swing.JButton botonSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cajaDemanda;
    private javax.swing.JTextField cajaNombArch;
    private javax.swing.JTextField cajaProbDeman;
    private javax.swing.JTextField cajaProbTEN;
    private javax.swing.JTextField cajaProbTESP;
    private javax.swing.JTextField cajaTEN;
    private javax.swing.JTextField cajaTESP;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JLabel etiqueta10;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JLabel etiqueta8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private javax.swing.JRadioButton rboton1;
    private javax.swing.JRadioButton rboton2;
    private javax.swing.JTable tablaDemandas;
    private javax.swing.JTable tablaTEntrega;
    private javax.swing.JTable tablaTEspera;
    // End of variables declaration//GEN-END:variables
}
