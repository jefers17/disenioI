/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.intsuperior.controlador;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author User
 */
public class Conexion_Arduino {
    private SerialPort puertoSerie;      
    
    public boolean conectar(int indice){        
        puertoSerie = SerialPort.getCommPorts()[indice];
        puertoSerie.openPort();
        puertoSerie.setComPortParameters(9600, 8, 1, 0);
        puertoSerie.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); 
        return estaConectado();
    }
    
    public static SerialPort[] getPuertosSerie() {
        SerialPort puertos[] = SerialPort.getCommPorts();
        return puertos;
    }    
        public boolean estaConectado() {
        return puertoSerie.isOpen();
    }

    public boolean desconectar() {
        return puertoSerie.closePort();
    }

    public boolean enviarNumero(int valor) {
        try {
            puertoSerie.getOutputStream().write((new Integer(valor)).byteValue());
            puertoSerie.getOutputStream().flush();
            return true;
        } catch (IOException ex) {            
            return false;
        }        
    }
    
    public boolean enviarLetra(char valor) {
        try {
            puertoSerie.getOutputStream().write(valor);
            puertoSerie.getOutputStream().flush();
            return true;
        } catch (IOException ex) {           
            return false;
        }        
    }
    
    public boolean enviarTexto(String texto) {
        try {
            puertoSerie.getOutputStream().write(texto.getBytes());
            puertoSerie.getOutputStream().flush();
            return true;
        } catch (IOException ex) {            
            return false;
        }        
    }
// Método para recibir un valor numérico desde Arduino
    public int recibirNumero() {
        try {
            InputStream inputStream = puertoSerie.getInputStream();
            int valor = inputStream.read(); // Lee un byte del puerto serial
            return valor;
        } catch (IOException ex) {
            ex.printStackTrace();
            return -1; // Si hay algún error, se devuelve un valor negativo
        }
    }
    
    // Método para recibir un caracter (byte) desde Arduino
    public char recibirLetra() {
        try {
            InputStream inputStream = puertoSerie.getInputStream();
            char valor = (char) inputStream.read(); // Lee un byte del puerto serial y lo convierte a char
            return valor;
        } catch (IOException ex) {
            ex.printStackTrace();
            return '\0'; // Si hay algún error, se devuelve el carácter nulo
        }
    }
    
    // Método para recibir una cadena de texto desde Arduino
    public String recibirTexto() {
        try {
            InputStream inputStream = puertoSerie.getInputStream();
            byte[] buffer = new byte[256];
            int bytesRead = inputStream.read(buffer); // Lee los datos del puerto serial y los almacena en el buffer
            String texto = new String(buffer, 0, bytesRead); // Convierte el buffer en una cadena de texto
            return texto;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null; // Si hay algún error, se devuelve null
        }
    }

}
    
