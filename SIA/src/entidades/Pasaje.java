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
 * Clase: pasaje
 * 09/11/2017
 * 
 * Modifico Gerardo Cardenas
 * 
 * Se cambia la varible valor a float
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Pasaje {
    
    private int idPasaje;
    private int idClase;
    private String asiento;
    private float valor;
    private int idCliente;
    private int idVuelo;

    public int getIdPasaje() {
        return idPasaje;
    }

    public void setIdPasaje(int idPasaje) {
        this.idPasaje = idPasaje;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Pasaje() {
    }

    public Pasaje(int idClase, String asiento, float valor, int idCliente, int idVuelo) {
        this.idClase = idClase;
        this.asiento = asiento;
        this.valor = valor;
        this.idCliente = idCliente;
        this.idVuelo = idVuelo;
    }

}
