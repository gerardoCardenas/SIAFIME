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

import java.sql.Date;

/**
 *
 * @author emmanuel medina
 * Clase: Cliente
 * Fecha: 9/11/2017
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Cliente {
   private int idCliente;
   private String nombre;
   private String apellido;
   private int edad;
   private String genero;
   private String telefono;
   private String direccion;
   private String email;
   private String lastUpdate;
   private String lastUpdateBy;
   

    public int getIdVuelo() {
        return idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setIdVuelo(int idVuelo) {
        this.idCliente = idVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public Cliente(String nombre, String apellido, int edad, String genero, String telefono, String direccion, String email, String lastUpdate, String lastUpdateBy) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }

    
    
     public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO `cliente`(`nombre`,`apellido`, `edad`,`genero`, `telefono`, `direccion`"
                + ", `email`, `lastUpdate`, `lastUpdateBy`) VALUES ('"+ nombre +"','"+ apellido +"', '" + edad +"','" + genero +"', '" 
                + telefono +"', '" + direccion +"', '" + email +"', '" + f.obtenerFecha() +"', '" + s1.obtenerUsuario() +"')" ;
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
        query = "UPDATE `cliente` SET `nombre`='" + this.nombre +"',`nombre`='" + this.apellido +"',`edad`='" + this.edad + "',`genero`='" + this.genero + "',"
                + "`telefono`='" + this.telefono + "'"
                + ",`direccion`='" + this.direccion + "',`email`='" + this.email + "',"
                + "`lastUpdate`='" + f.obtenerFecha() + "',`lastUpdateBy`='" + s.obtenerUsuario() + "'"
                + " WHERE `cliente`.`idCliente` = " + this.idCliente + ";";
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
        query = "DELETE FROM `cliente` WHERE `cliente`.`idCliente` = " +this.idCliente;
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
   public int registrarClienteVuelo(){
       Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        int rowsA = 0;
        String query = "INSERT INTO `cliente`(`nombre`,`apellido`, `edad`,`genero`, `telefono`, `direccion`"
                + ", `email`, `lastUpdate`, `lastUpdateBy`) VALUES ('"+ nombre +"','"+ apellido +"', '" + edad +"','" + genero +"', '" 
                + telefono +"', '" + direccion +"', '" + email +"', '" + f.obtenerFecha() +"', '" + s1.obtenerUsuario() +"')" ;
        try {
            PreparedStatement ps = co.prepareStatement(query);
            rowsA = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }
        finally{
            try {
                co.close();
            } catch (Exception e) {
            }
        }
        return rowsA;
   }
}
