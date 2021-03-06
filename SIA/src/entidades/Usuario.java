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
import lanzadores.EmpleadoLaunch;
import lanzadores.LoginLaunch;
import sia.Fechas;

/**
 *
 * @author Gerardo
 * 29/10/2017
 * Se cierra la conexion ala base de datos.
 * 
 * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String contraseña;
    private String tipoUsuario;
    private String lastUpdateBy;
    private String lastUpdate;
    
    //Se aplica el encapsulamiento
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    //Se hace el metodo personalizado del select para validar el usuario
    public boolean Login(String usuario, String contraseña){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        String query = "SELECT * FROM `usuarios` WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "'";
        Statement stQuery;
        
        try {
            stQuery = co.createStatement();
            PreparedStatement ps = co.prepareStatement(query);
            ResultSet r1 = stQuery.executeQuery(query);
            r1.next();
            Usuario datos = new Usuario(r1.getString("Usuario"),r1.getString("Contraseña"), r1.getString("TipoUsuario"));
            datos.setIdUsuario(r1.getInt("idUsuario"));
            
            if(!datos.getUsuario().equals(usuario) || !(datos.getContraseña().equals(contraseña))){
                throw new Exception("Usuario Invalido");
            }
            if(datos.getTipoUsuario().equals("Cliente")){
                throw new Exception("No tiene los permisos para este sistema por favor entre a la pagina web de sia");
            }
            else{
                if(datos.getTipoUsuario().equals("Administrador")){
                AdministradorLaunch al1 = new AdministradorLaunch();
                al1.launch();
                LoginLaunch l1 = new LoginLaunch();
                l1.close();
                }
                else{
                    if(datos.getTipoUsuario().equals("Empleado")){
                    EmpleadoLaunch el = new EmpleadoLaunch();
                    el.launch();
                    LoginLaunch l1 = new LoginLaunch();
                    l1.close();
                    }
                }
                Sesion s1 = new Sesion();
                s1.persistir(datos);
                JOptionPane.showMessageDialog(null, "Bienvenido " + s1.obtenerUsuario());
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{//Se cierra la conexion
            try {
                co.close();
            } catch (Exception e) {
            }
        }
        return true;
    }

    public Usuario( String usuario, String contraseña, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }
    //Se inserta el usuario
    public boolean insert(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        Fechas f = new Fechas();
        Sesion s1 = new Sesion();
        String query = "INSERT INTO `usuarios` (`Usuario`, `Contraseña`, `TipoUsuario`, `lastUpdate`, `lastUpdateBy`) VALUES ('" + usuario+"', '"  + contraseña + "', '" + tipoUsuario+"', '"  + f.obtenerFecha()+"','"+ s1.obtenerUsuario()+"');" ;
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
        query = "UPDATE `usuarios` SET `Usuario` = '" + this.usuario+"', `Contraseña` = '" + this.contraseña +"', `TipoUsuario` = '"+ tipoUsuario + "', `lastUpdate` = '" +f.obtenerFecha()+"', `lastUpdateBy` = '"+s.obtenerUsuario()+"' WHERE `usuarios`.`idUsuario` = "+ this.idUsuario + ";";
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
        query = "DELETE FROM `usuarios` WHERE `usuarios`.`idUsuario` = " +this.idUsuario;
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
    public boolean find(){
        
        return false;
    }
}
