/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Gerardo
 * Clase: Vuelo
 * 09/11/2017
 * 
 * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Vuelo {
    private int idVuelo;
    private int capacidad;
    private int idOrigen;
    private int idDestino;
    private float precioBase;
    private String  modeloAvion;
    private int idEscala;
    private int idAerolinea;

    public int getIdVuelo() {
        return idVuelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public int getIdEscala() {
        return idEscala;
    }

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public Vuelo() {
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public void setIdEscala(int idEscala) {
        this.idEscala = idEscala;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public Vuelo(int capacidad, int idOrigen, int idDestino, float precioBase, String modeloAvion, int idEscala, int idAerolinea) {
        this.capacidad = capacidad;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.precioBase = precioBase;
        this.modeloAvion = modeloAvion;
        this.idEscala = idEscala;
        this.idAerolinea = idAerolinea;
    }
    
    
}
