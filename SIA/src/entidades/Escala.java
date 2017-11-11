/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *09/11/2017
 * @author Pablo I
 * Entidad escala
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Escala {
    private int idEscala;
    private String descripcion;
    private Date lastUpdate;
    private String lastUpdateBy;

    public int getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(int idEscala) {
        this.idEscala = idEscala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
    
    public Escala() {
    }

    public Escala(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
