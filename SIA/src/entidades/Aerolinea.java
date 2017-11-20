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
 * Clase: Aerolinea
 * 09/11/2017
 * 
 * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Aerolinea {
    private int idAerolinea;
    private String nombre;
    private String lastUpdate;
    private String lastUpdateBy;
    
    

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aerolinea() {
    }

    public Aerolinea(String nombre) {
        this.nombre = nombre;
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

    
    
    public Aerolinea(String nombre, String lastUpdate, String lastUpdateBy) {
        this.nombre = nombre;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }
    
    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO  `sia`.`aerolineas` (\n" +
            "`Nombre` ,\n" +
            "`lastUpdate` ,\n" +
            "`lastUpdateBy`\n" +
            ")\n" +
            "VALUES (\n" +
            "'" + nombre + "',  '" + f.obtenerFecha() + "',  '" + s1.obtenerUsuario() +"'\n" +
            ");";
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
        query = "UPDATE `aerolineas` SET `nombre`= '"+ this.nombre+"',`lastUpdate`='" + f.obtenerFecha() +"',`lastUpdateBy`='" + s.obtenerUsuario() +"' WHERE `aerolineas`.`idAerolineas` = " + this.idAerolinea + ";";
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
        query = "DELETE FROM `aerolineas` WHERE `aerolineas`.`idAerolineas` = " + this.idAerolinea;
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