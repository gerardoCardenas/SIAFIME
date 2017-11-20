/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Aerolinea;

/**
 *
 * @author Gerardo
 */
public class AerolineaFacade {
    private static Aerolinea aerolinea = new Aerolinea();
    private static String estado;

    public static Aerolinea getAerolinea() {
        return aerolinea;
    }

    public static void setAerolinea(Aerolinea aerolinea) {
        AerolineaFacade.aerolinea = aerolinea;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        AerolineaFacade.estado = estado;
    }
}
