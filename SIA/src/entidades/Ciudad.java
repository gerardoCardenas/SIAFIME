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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import lanzadores.AdministradorLaunch;
import lanzadores.LoginLaunch;
import sia.Fechas;


/**
 *
 * @author Gerardo
 */
public class Ciudad {

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }
    private int idCiudad;
    private String nombre;
    private String lastUpdate;
   private String lastUpdateBy; 
    
    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad() {
    }

    public Ciudad(String nombre, String lastUpdate, String lastUpdateBy) {
        this.nombre = nombre;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO `ciudad`(`nombre`) VALUES ('" + nombre +"', '" + f.obtenerFecha() +"', '" + s1.obtenerUsuario() +"' );";
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
        finally{
            try {
                co.close();
            } catch (Exception e) {
            }
        }
        return val;
    }
    
    public boolean update(){
        Conexion cm = new Conexion();
        Connection co = cm.conectar();
        String query;
        Fechas f = new Fechas();
        Sesion s = new Sesion();
        query = "UPDATE `ciudad` SET `nombre`='" + this.nombre +"',`Update`='" + 
                f.obtenerFecha() +"',`UpdateBy`='" + s.obtenerUsuario() 
                +"' WHERE `ciudad`.`idCiudad` = " + this.idCiudad +";";
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
        query = "DELETE FROM `ciudad` WHERE `ciudad`.`idCiudad` = " +this.idCiudad;
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
        finally{
            try {
                co.close();
            } catch (Exception e) {
            }
        }
        return val;
    }
}
