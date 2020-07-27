
package Ventanas;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author Kharen y Gabriela
 */
public class Ventana1 extends javax.swing.JFrame {
    public static double costoInv , costoOrden, costoFE, costoFSE, costoComp;
    public static int invIn, tiempoS;
    public static Principal.Tiempo etiqueta;

    public Ventana1() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton2 = new javax.swing.JButton();
        boton1 = new javax.swing.JButton();
        etiqueta1 = new javax.swing.JLabel();
        comboxUnidades = new javax.swing.JComboBox<>();
        etiqueta2 = new javax.swing.JLabel();
        cajaCostoCompra = new javax.swing.JTextField();
        cajaTiempoS = new javax.swing.JTextField();
        etiqueta4 = new javax.swing.JLabel();
        cajaCostoOrden = new javax.swing.JTextField();
        cajaCostoInv = new javax.swing.JTextField();
        etiqueta5 = new javax.swing.JLabel();
        etiqueta6 = new javax.swing.JLabel();
        cajaCostoFE = new javax.swing.JTextField();
        etiqueta7 = new javax.swing.JLabel();
        cajaCostoFSE = new javax.swing.JTextField();
        etiqueta3 = new javax.swing.JLabel();
        cajaInvIn = new javax.swing.JTextField();
        etiqueta9 = new javax.swing.JLabel();
        etiqueta11 = new javax.swing.JLabel();
        Fondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton2.setBackground(new java.awt.Color(255, 255, 255));
        boton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boton2.setText("Siguiente");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 120, 40));

        boton1.setBackground(new java.awt.Color(255, 255, 255));
        boton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        boton1.setText("Salir");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        getContentPane().add(boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 120, 40));

        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta1.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta1.setText("Unidad de tiempo:");
        getContentPane().add(etiqueta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 200, 30));

        comboxUnidades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboxUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Días", "Semanas", "Meses", "Bimestres", "Trimestres" }));
        getContentPane().add(comboxUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 140, 30));

        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta2.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta2.setText("Tiempo de Simulación:");
        getContentPane().add(etiqueta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        cajaCostoCompra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaCostoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCostoCompraActionPerformed(evt);
            }
        });
        cajaCostoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCostoCompraKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCostoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 140, 30));

        cajaTiempoS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaTiempoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTiempoSActionPerformed(evt);
            }
        });
        cajaTiempoS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTiempoSKeyTyped(evt);
            }
        });
        getContentPane().add(cajaTiempoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 140, 30));

        etiqueta4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta4.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta4.setText("Costo de inventario[$/unidad/año]: ");
        getContentPane().add(etiqueta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        cajaCostoOrden.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaCostoOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCostoOrdenActionPerformed(evt);
            }
        });
        cajaCostoOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCostoOrdenKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCostoOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 140, 30));

        cajaCostoInv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaCostoInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCostoInvActionPerformed(evt);
            }
        });
        cajaCostoInv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCostoInvKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCostoInv, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 30));

        etiqueta5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta5.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta5.setText("Costo de compra[$/unidad]: ");
        getContentPane().add(etiqueta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 20));

        etiqueta6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta6.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta6.setText("Costo faltante con espera[$/unidad]: ");
        getContentPane().add(etiqueta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, 20));

        cajaCostoFE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaCostoFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCostoFEActionPerformed(evt);
            }
        });
        cajaCostoFE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCostoFEKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCostoFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 140, 30));

        etiqueta7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta7.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta7.setText("Costo faltante sin espera[$/unidad]: ");
        getContentPane().add(etiqueta7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, 20));

        cajaCostoFSE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaCostoFSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCostoFSEActionPerformed(evt);
            }
        });
        cajaCostoFSE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCostoFSEKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCostoFSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 140, 30));

        etiqueta3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta3.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta3.setText("Costo de orden[$/orden]: ");
        getContentPane().add(etiqueta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        cajaInvIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cajaInvIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaInvInActionPerformed(evt);
            }
        });
        cajaInvIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaInvInKeyTyped(evt);
            }
        });
        getContentPane().add(cajaInvIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, 140, 30));

        etiqueta9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqueta9.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta9.setText("Inventario inicial[unidades]: ");
        getContentPane().add(etiqueta9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 20));

        etiqueta11.setBackground(new java.awt.Color(255, 255, 255));
        etiqueta11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        etiqueta11.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta11.setText("SIMULADOR");
        getContentPane().add(etiqueta11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 330, 40));

        Fondo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Fondo2.setForeground(new java.awt.Color(255, 255, 255));
        Fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/image5.JPG"))); // NOI18N
        getContentPane().add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 540));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_boton1ActionPerformed

    private void cajaCostoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCostoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCostoCompraActionPerformed

    private void cajaCostoOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCostoOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCostoOrdenActionPerformed

    private void cajaCostoInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCostoInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCostoInvActionPerformed

    private void cajaCostoFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCostoFEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCostoFEActionPerformed

    private void cajaCostoFSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCostoFSEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaCostoFSEActionPerformed

    private void cajaTiempoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTiempoSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTiempoSActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        int opcion = -1;
        String unidad = "";
        Ventana2 v2 = new Ventana2();
        
        if ( validarTextFields() == false){
            JOptionPane.showMessageDialog(null, "¡Alerta! : Ningún campo puede estar vacio.");
            return;
        }
        tiempoS = Integer.parseInt(cajaTiempoS.getText());
        costoInv = Double.parseDouble(cajaCostoInv.getText());
        costoOrden = Double.parseDouble(cajaCostoOrden.getText()); 
        costoFE = Double.parseDouble(cajaCostoFE.getText());
        costoFSE = Double.parseDouble(cajaCostoFSE.getText());
        costoComp =  Double.parseDouble(cajaCostoCompra.getText());
        invIn = Integer.parseInt(cajaInvIn.getText());
        unidad = (String) comboxUnidades.getSelectedItem(); 
        
        if (unidad.equals("Dias")){
            opcion = 1;
        }
         if (unidad.equals("Semanas")){
            opcion = 2;
        } 
        if (unidad.equals("Meses")){
            opcion = 3;
        }
        if (unidad.equals("Bimestres")){
            opcion = 4;
        }
        if (unidad.equals("Trimestres")){
            opcion = 5;
        }
        etiqueta = Principal.enviarEtiquetas(opcion);
        v2.setVisible(true);
        this.setVisible(false);        
    }//GEN-LAST:event_boton2ActionPerformed

    private void cajaInvInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaInvInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaInvInActionPerformed

    private void cajaTiempoSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTiempoSKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_cajaTiempoSKeyTyped

    private void cajaCostoInvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCostoInvKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaCostoInv.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCostoInvKeyTyped

    private void cajaCostoOrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCostoOrdenKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaCostoOrden.getText().contains(".")) ) {
            evt.consume();
        }  
    }//GEN-LAST:event_cajaCostoOrdenKeyTyped

    private void cajaCostoCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCostoCompraKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaCostoCompra.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCostoCompraKeyTyped

    private void cajaCostoFEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCostoFEKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaCostoFE.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCostoFEKeyTyped

    private void cajaCostoFSEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCostoFSEKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c> '9')) 
        && (c != KeyEvent.VK_BACK_SPACE)
        && (c != '.' || cajaCostoFSE.getText().contains(".")) ) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCostoFSEKeyTyped

    private void cajaInvInKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaInvInKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_cajaInvInKeyTyped
    
    private Boolean validarTextFields(){
        
       if(cajaTiempoS.getText().length() == 0){
          return false;
       }
       if(cajaCostoInv.getText().length() == 0){
          return false;
       } 
       if(cajaCostoOrden.getText().length() == 0){
          return false;
       }
      if(cajaCostoCompra.getText().length() == 0){
          return false;
       }
      if(cajaCostoFE.getText().length() == 0){
          return false;
       }
      if(cajaCostoFSE.getText().length() == 0){
          return false;
      }
      if(cajaInvIn.getText().length() == 0){
          return false;
       }
    return true;}

    public static void main(String[] args) throws IOException  {{
      
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
        /*Create and display the form*/
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana1().setVisible(true);
                
            }
        });
    }   
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo2;
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JTextField cajaCostoCompra;
    private javax.swing.JTextField cajaCostoFE;
    private javax.swing.JTextField cajaCostoFSE;
    private javax.swing.JTextField cajaCostoInv;
    private javax.swing.JTextField cajaCostoOrden;
    private javax.swing.JTextField cajaInvIn;
    private javax.swing.JTextField cajaTiempoS;
    private javax.swing.JComboBox<String> comboxUnidades;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JLabel etiqueta11;
    private javax.swing.JLabel etiqueta2;
    private javax.swing.JLabel etiqueta3;
    private javax.swing.JLabel etiqueta4;
    private javax.swing.JLabel etiqueta5;
    private javax.swing.JLabel etiqueta6;
    private javax.swing.JLabel etiqueta7;
    private javax.swing.JLabel etiqueta9;
    // End of variables declaration//GEN-END:variables
}
