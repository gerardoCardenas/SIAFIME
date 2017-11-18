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
    private String capacidad;
    private String  modeloAvion;
    private String numeroVuelo;
    private int idConpañia;
    private int idEscala;
    private String lastUpdate;
    private int idOrigen;
    private int idDestino;

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public int getIdConpañia() {
        return idConpañia;
    }

    public void setIdConpañia(int idConpañia) {
        this.idConpañia = idConpañia;
    }

    public int getEscala() {
        return idEscala;
    }

    public void setEscala(int escala) {
        this.idEscala = escala;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }
    

    public Vuelo(String capacidad, String modeloAvion, String numeroVuelo, int idConpañia, int idEscala, int idOrigen, int idDestino) {
        this.capacidad = capacidad;
        this.modeloAvion = modeloAvion;
        this.numeroVuelo = numeroVuelo;
        this.idConpañia = idConpañia;
        this.idEscala = idEscala;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
    }

    public Vuelo() {
    }
}
