/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
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
 *09/11/2017
 * @author Pablo I
 * Entidad escala
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Escala {
    private int idEscala;
    private String descripcion;
    private String lastUpdate;
    private String lastUpdateBy;

    public int getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(int idEscala) {
        this.idEscala = idEscala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    public Escala() {
    }

    public Escala(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //Se inserta el usuario
    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO `escala`(`descripcion`, `lastUpdate`, `lastUpdateBy`) "
                + "VALUES ('" + descripcion + "', '" + f.obtenerFecha() + "', '" + s1.obtenerUsuario() +"' )";
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
        query = "UPDATE `escala` SET `descripcion`= '" + this.descripcion + "',`lastUpdate`= '" + f.obtenerFecha() 
                + "',` lastUpdateBy`= '" + s.obtenerUsuario() +"' WHERE escala.idescala = " + this.descripcion +" ;";
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
        query = "DELETE FROM `escala` WHERE `escala`.`idescala` = " +this.idEscala;
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

    public Escala(String descripcion, String lastUpdate, String lastUpdateBy) {
        this.descripcion = descripcion;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    
}
