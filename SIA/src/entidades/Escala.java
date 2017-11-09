/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *09/11/2017
 * @author Pablo I
 * Entidad escala
 */
public class Escala {
    private int idEscala;
    private String descripcion;

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

    public Escala() {
    }

    public Escala(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
