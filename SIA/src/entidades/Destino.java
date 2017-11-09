/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *09/11/2017
 * @author Pablo I
 * Clase Destino
 */
public class Destino {
    private int idDestino;
    private String nAerolineas;
    private String ciudad;
    private int idCiudad;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getnAerolineas() {
        return nAerolineas;
    }

    public void setnAerolineas(String nAerolineas) {
        this.nAerolineas = nAerolineas;
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

    public Destino() {
    }

    public Destino(String nAerolineas, String ciudad, int idCiudad) {
        this.nAerolineas = nAerolineas;
        this.ciudad = ciudad;
        this.idCiudad = idCiudad;
    }
    
    
}
