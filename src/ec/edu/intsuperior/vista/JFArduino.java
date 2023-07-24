/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.intsuperior.vista;

import java.awt.Color;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.fazecast.jSerialComm.SerialPort;
import ec.edu.intsuperior.controlador.Conexion_Arduino;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */

public class JFArduino extends javax.swing.JFrame {
private Conexion_Arduino arduino;
    /**
     * Creates new form JFArduino
     */
    public JFArduino() {
        initComponents();
        arduino= new Conexion_Arduino();
        cargarPuertos();
    }
    public  void imagenPuertaCerrada(){
        
        ImageIcon puerta;
        puerta =new ImageIcon(getClass().getResource("/images/puerta_cerrada.png"));
        Icon puertaIcono =new ImageIcon(puerta.getImage().getScaledInstance(jblImagen.getWidth(), jblImagen.getHeight(), Image.SCALE_SMOOTH));
        jblImagen.setIcon(puertaIcono);
    }
    public  void imagenPuertaAbierta(){
        ImageIcon puerta;
        puerta=new ImageIcon(getClass().getResource("/images/puerta_abierta.png"));
        Icon puertaIcono =new ImageIcon(puerta.getImage().getScaledInstance(jblImagen.getWidth(), jblImagen.getHeight(), Image.SCALE_SMOOTH));
        jblImagen.setIcon(puertaIcono);
           }
    private void mostrarFechaHoraActual() {
    // Obtener la fecha y hora actuales
    LocalDateTime fechaHoraActual = LocalDateTime.now();

    // Formatear la fecha y hora según el formato deseado
    String formato = "dd/MM/yyyy HH:mm:ss";
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
    String fechaHoraFormateada = fechaHoraActual.format(formateador);

    // Mostrar la fecha y hora en la etiqueta
    jlFecha.setText( fechaHoraFormateada);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jblImagen = new javax.swing.JLabel();
        jlmensaje = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        btncambiar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        cbmpuertos = new javax.swing.JComboBox<>();
        btnconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlmensaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlmensaje.setText("LA PUERTA ESTA CERRADA");

        jlFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlFecha.setText("DD/MES/AÑO:HORA");

        btncambiar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btncambiar.setText("OFF");
        btncambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncambiarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("PUERTOS");

        cbmpuertos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnconectar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnconectar.setText("CONECTAR");
        btnconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnconectarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jlmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(cbmpuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnconectar)
                        .addGap(53, 53, 53)
                        .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbmpuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncambiarActionPerformed
        // TODO add your handling code here:
                                              
    // Verificar si el Arduino está conectado
    if (arduino.estaConectado()) {
        // Enviar el comando al Arduino
        if (btncambiar.isSelected()) {
            arduino.enviarTexto("1");
            btncambiar.setBackground(new Color(51, 51, 255));
            btncambiar.setText("ON");
            jlmensaje.setText("LA PUERTA ESTA ABIERTA");
            mostrarFechaHoraActual();
            imagenPuertaAbierta();
        } else {
            arduino.enviarTexto("2");
            btncambiar.setBackground(Color.white);
            btncambiar.setText("OFF");
            jlmensaje.setText("LA PUERTA ESTA CERRADA");
            mostrarFechaHoraActual();
            imagenPuertaCerrada();
        }
        
        // Recibir el valor del Arduino
        String valorRecibido = arduino.recibirTexto();
        if (valorRecibido != null && !valorRecibido.isEmpty()) {
            // Actualizar el estado del botón según el valor recibido
            if (valorRecibido.equals("1")) {
                btncambiar.setSelected(true);
                btncambiar.setBackground(new Color(51, 51, 255));
                btncambiar.setText("ON");
                jlmensaje.setText("LA PUERTA ESTA ABIERTA");
                mostrarFechaHoraActual();
                imagenPuertaAbierta();
            } else if (valorRecibido.equals("2")) {
                btncambiar.setSelected(false);
                btncambiar.setBackground(Color.white);
                btncambiar.setText("OFF");
                jlmensaje.setText("LA PUERTA ESTA CERRADA");
                mostrarFechaHoraActual();
                imagenPuertaCerrada();
            } else {
                // En caso de que no se reciba ningún valor válido, mostrar un mensaje de error
                JOptionPane.showMessageDialog(this, "Error al recibir el valor desde Arduino");
            }
        }
    } else {
        // Mostrar mensaje de error si no se puede conectar al Arduino
        JOptionPane.showMessageDialog(this, "Error: No se pudo conectar al Arduino");
    }


     
    }//GEN-LAST:event_btncambiarActionPerformed

    private void btnconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnconectarMouseClicked
        // TODO add your handling code here:
        int i=this.cbmpuertos.getSelectedIndex();
        
        if(arduino.conectar(i)){
            JOptionPane.showMessageDialog(this, "CONECTADO");
            this.btnconectar.setBackground(Color.green);
        }else{
            JOptionPane.showMessageDialog(this, "ERROR");
            this.btnconectar.setBackground(Color.red);
        }
    }//GEN-LAST:event_btnconectarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(JFArduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFArduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFArduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFArduino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new JFArduino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btncambiar;
    private javax.swing.JButton btnconectar;
    private javax.swing.JComboBox<String> cbmpuertos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jblImagen;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlmensaje;
    // End of variables declaration//GEN-END:variables
    
    private void cargarPuertos(){
        SerialPort[]puertos= Conexion_Arduino.getPuertosSerie();
        this.cbmpuertos. removeAllItems();
        for(int i=0;i<puertos.length;i++){
            cbmpuertos.addItem(puertos[i].getSystemPortName());
        }
    }
}
