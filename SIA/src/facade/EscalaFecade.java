/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Escala;

/**
 *
 * @author Pablo I
 */
public class EscalaFecade {
    private static Escala escala = new Escala();
    private static String estado;

    public static Escala getUsuario() {
        return escala;
    }

    public static void setUsuario(Escala escala) {
        EscalaFecade.escala = escala;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
       EscalaFecade.estado = estado;
    }

}
