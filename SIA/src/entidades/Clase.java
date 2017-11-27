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
/**
 *
 * @author Pablo I
 */
public class Clase {
    
    private int idClase;
    private String descripcion;
    private float aumento;

    public int getIdClase() {
        return idClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getAumento() {
        return aumento;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAumento(float aumento) {
        this.aumento = aumento;
    }
    
    public Clase() {
    }

    public Clase(String descripcion, float aumento) {
        this.descripcion = descripcion;
        this.aumento = aumento;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
    
    
}
