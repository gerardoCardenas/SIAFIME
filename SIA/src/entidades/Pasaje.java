/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import db.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author emmanuel medina
 * Clase: pasaje
 * 09/11/2017
 * 
 * Modifico Gerardo Cardenas
 * 
 * Se cambia la varible valor a float
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Pasaje {
    
    private int idPasaje;
    private int idClase;
    private String asiento;
    private float valor;
    private int idCliente;
    private int idVuelo;

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Pasaje() {
    }

    public Pasaje(int idClase, String asiento, int idCliente, int idVuelo) {
        this.idClase = idClase;
        this.asiento = asiento;
        this.idCliente = idCliente;
        this.idVuelo = idVuelo;
    }
    
    public boolean delete(){
        Conexion cm = new Conexion();
        Connection co = cm.conectar();
        String query;
        query = "DELETE FROM `pasaje` WHERE `pasaje`.`idPasaje` = " + this.idPasaje;
        boolean val = false;
        try {
            PreparedStatement ps = co.prepareStatement(query);
            int rowsA = ps.executeUpdate();
            if(rowsA != 0 )
            {
                val = true;
            }
            else
            {
                val = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: Este elemento no se elimino correctamente es posible que informacion de otras tablas dependan de este registro" + e);
        }
        return val;
    }

}
