/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import db.Conexion;
import db.Sesion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import sia.Fechas;

/**
 *09/11/2017
 * @author Pablo I
 * Origen
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Origen {
    private int idOrigen;
    private int aerolinea;
    private int ciudad;
    private String nombreAerolinea;
    private String nombreCiudad;
    private String lastUpdate;
    private String lastUpdateBy;
    
    
    //Se aplica el encapsulamiento

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public int getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(int aerolinea) {
        this.aerolinea = aerolinea;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
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

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
    
    

    public Origen() {
    }

    public Origen(int aerolinea, int ciudad, String nombreAerolinea, String nombreCiudad, String lastUpdate, String lastUpdateBy) {
        this.aerolinea = aerolinea;
        this.ciudad = ciudad;
        this.nombreAerolinea = nombreAerolinea;
        this.nombreCiudad = nombreCiudad;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    

    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO  `sia`.`origen` (\n" +
            "`idAerolinea` ,\n" +
            "`idCiudad` ,\n" +
            "`lastUpdate` ,\n" +
            "`lastUpdateBy`\n" +
            ")\n" +
            "VALUES (\n" +
            "'" + aerolinea + "',  '" + ciudad + "', '"+ f.obtenerFecha() + "',  '" + s1.obtenerUsuario() +"'\n" +
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
        query = "UPDATE `sia`.`origen` SET `idAerolinea`= '"+ this.aerolinea+ "', ´idCiudad´ = " + this.ciudad +"',`lastUpdate`='" + f.obtenerFecha() +"',`lastUpdateBy`='" + s.obtenerUsuario() +"' WHERE `aerolineas`.`idAerolineas` = " + this.idOrigen + ";";
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
        query = "DELETE FROM `origen` WHERE `origen`.`idOrigen` = " + this.idOrigen;
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
