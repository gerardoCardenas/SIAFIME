/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import db.Conexion;
import entidades.Aerolinea;
import entidades.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Cardenas
 */
public class CiudadFacade {
    private static Ciudad ciudad;
    private static String estado;

    public static Ciudad getCiudad() {
        return ciudad;
    }

    public static void setCiudad(Ciudad ciudad) {
        CiudadFacade.ciudad = ciudad;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        CiudadFacade.estado = estado;
    }

    public static Ciudad findById(int id){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `ciudad` WHERE idCiudad = " + id;
        Statement stquery;
        Ciudad c = new Ciudad();
        try {
            stquery = co.createStatement();
            PreparedStatement ps1 = co.prepareStatement(query);
            ResultSet r1 = stquery.executeQuery(query);
            while(r1.next()){
                c.setNombre(r1.getString("nombre"));
                c.setLastUpdate(r1.getString("lastUpdate"));
                c.setLastUpdateBy(r1.getString("lastUpdateBy"));
                c.setIdCiudad(r1.getInt("idCiudad"));
            }
            return c;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en relleno de datos: " + e);
            return null;
        }
    }
}
