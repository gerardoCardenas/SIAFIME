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
 * Origen
 * 
 *  * 10/11/2017 
 * Modifico Gerardo Cardenas
 * 
 * Se agrega el lastUpdate
 */
public class Origen {
    private int idOrigen;
    private String nAerolinea;
    private String ciudad;
    private int idCiudad;
    private Date lastUpdate;
    private String lastUpdateBy;
    
    
    //Se aplica el encapsulamiento

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getnAerolinea() {
        return nAerolinea;
    }

    public void setnAerolinea(String nAerolinea) {
        this.nAerolinea = nAerolinea;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
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

    public Origen() {
    }

    public Origen(String nAerolinea, String ciudad, int idCiudad) {
        this.nAerolinea = nAerolinea;
        this.ciudad = ciudad;
        this.idCiudad = idCiudad;
    }
    
    
}
