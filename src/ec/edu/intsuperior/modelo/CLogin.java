/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.modelo;

import ec.edu.intsuperior.controlador.Conexion;
//import ec.edu.intsuperior.vista.FArduino;
import ec.edu.intsuperior.vista.JFArduino;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class CLogin {
    public void validaUsuario(JTextField usuario, JPasswordField contrasenia){
        try {
            ResultSet rs=null;
            PreparedStatement ps=null;
            Conexion objetoConexion = new Conexion();
            String consulta="select*from usuario where usuario.user=(?) and usuario.PASSWORD=(?);";
            ps= objetoConexion.estableceConexion().prepareStatement(consulta);
            String contra=String.valueOf(contrasenia.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2, contra);
            rs =ps.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "El Usuario es correcto");
                JFArduino objetoArduino =new  JFArduino();
                objetoArduino.setVisible(true);
                 
              
            }
            else{
                JOptionPane.showMessageDialog(null, "El Usuario o La cotraseña es incorrecta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
}
