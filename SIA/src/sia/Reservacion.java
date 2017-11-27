/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia;

import db.Conexion;
import entidades.Clase;
import entidades.Cliente;
import entidades.Vuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo
 */
public class Reservacion {
    private static Vuelo vuelo;
    private static Cliente cliente;
    private static Clase clase;
    public static int asiento = 1;

    public static Vuelo getVuelo() {
        return vuelo;
    }

    public static void setVuelo(Vuelo vuelo) {
        Reservacion.vuelo = vuelo;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Reservacion.cliente = cliente;
    }

    public static Clase getClase() {
        return clase;
    }

    public static void setClase(Clase clase) {
        Reservacion.clase = clase;
    }
    public static int reservar(){
        Conexion c1 = new Conexion();
        Connection co = c1.conectar();
        asiento = asiento + 1;
        int rowsA = 0;
        String query = "INSERT INTO `pasaje`(`idClase`, `asiento`, `idCliente`, `idVuelo`) VALUES(" + clase.getIdClase()+ ", " + asiento + ", " + cliente.getIdCliente()+ ", " + vuelo.getIdVuelo()+");" ;
        try {
            PreparedStatement ps = co.prepareStatement(query);
            rowsA = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al reservar el vuelo porfavor contacte al administrador");
        }
        return rowsA;
    }
}
