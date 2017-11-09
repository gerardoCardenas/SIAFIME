/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *09/11/2017
 * @author Pablo I
 * Origen
 */
public class Origen {
    private int idOrigen;
    private String nAerolinea;
    private String ciudad;
    private int idCiudad;
    
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

    public Origen() {
    }

    public Origen(String nAerolinea, String ciudad, int idCiudad) {
        this.nAerolinea = nAerolinea;
        this.ciudad = ciudad;
        this.idCiudad = idCiudad;
    }
    
    
}
