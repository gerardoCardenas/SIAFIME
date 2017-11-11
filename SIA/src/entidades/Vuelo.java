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
    private String escala;
    private Date lastUpdate;

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

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Vuelo(String capacidad, String modeloAvion, String numeroVuelo, int idConpañia, String escala) {
        this.capacidad = capacidad;
        this.modeloAvion = modeloAvion;
        this.numeroVuelo = numeroVuelo;
        this.idConpañia = idConpañia;
        this.escala = escala;
    }

    public Vuelo() {
    }
}
