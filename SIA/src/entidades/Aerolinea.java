/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Gerardo
 * Clase: Aerolinea
 * 09/11/2017
 */
public class Aerolinea {
    private int idAerolinea;
    private String nombre;

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aerolinea() {
    }

    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }
}
