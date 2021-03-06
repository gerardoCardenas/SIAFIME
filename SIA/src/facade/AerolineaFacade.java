/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import db.Conexion;
import entidades.Aerolinea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo
 */
public class AerolineaFacade {
    private static Aerolinea aerolinea = new Aerolinea();
    private static String estado;

    public static Aerolinea getAerolinea() {
        return aerolinea;
    }

    public static void setAerolinea(Aerolinea aerolinea) {
        AerolineaFacade.aerolinea = aerolinea;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        AerolineaFacade.estado = estado;
    }
    
    public static Aerolinea findById(int id){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `aerolineas` WHERE idaerolineas = " + id;
        Statement stquery;
        Aerolinea a1 = new Aerolinea();
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                a1.setNombre(r1.getString("nombre"));
                a1.setLastUpdate(r1.getString("lastUpdate"));
                a1.setLastUpdateBy(r1.getString("lastUpdateBy"));
                a1.setIdAerolinea(r1.getInt("idaerolineas"));
            }
            return a1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
            return null;
        }
    }
}
