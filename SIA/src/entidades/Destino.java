/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import db.Conexion;
import db.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import sia.Fechas;


/**
 *09/11/2017
 * @author Pablo I
 * Clase Destino
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Destino {
    private int idDestino;
    private int idAerolinea;
    private int idCiudad;
    private String lastUpdate;
    private String lastUpdateBy;


    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }


    public Destino() {
    }

    public Destino(int idAerolinea, int idCiudad, String lastUpdate, String lastUpdateBy) {
        this.idAerolinea = idAerolinea;
        this.idCiudad = idCiudad;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO `destino`(`idAerolinea`, `idCiudad`, `lastUpdate`, `lastUpdateBy`) VALUES (" + this.idAerolinea+ "," + this.idCiudad + ", '" + f.obtenerFecha()+"'" + ",'" + s1.obtenerUsuario()+"');"; 
        boolean val = false;
        System.out.println(query);
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
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
        return val;
    }
    
    public boolean update(){
        Conexion cm = new Conexion();
        Connection co = cm.conectar();
        String query;
        Fechas f = new Fechas();
        Sesion s = new Sesion();
        query = "UPDATE `destino` SET `idAerolinea`= " + this.idAerolinea + ", `idCiudad` = " + this.idCiudad + ", `lastUpdate`= '" + f.obtenerFecha()+"', `lastUpdateBy`='" + s.obtenerUsuario()+"' WHERE `idDestino` = "+ this.idDestino+";";
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
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
        return val;
    }
    public boolean delete(){
        Conexion cm = new Conexion();
        Connection co = cm.conectar();
        String query;
        query = "DELETE FROM `destino` WHERE `idDestino` =" + this.idDestino;
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
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
        return val;
    }
}
