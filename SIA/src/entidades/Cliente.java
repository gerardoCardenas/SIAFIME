/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
   private int edad;
   private String telefono;
   private String direccion;
   private String email;
   private String lastUpdate;
   private String lastUpdateBy;
   

    public int getIdVuelo() {
        return idCliente;
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
    
    

    public Cliente(String nombre, int edad, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    
   
   
}
