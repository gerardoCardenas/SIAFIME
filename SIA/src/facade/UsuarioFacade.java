/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Usuario;

/**
 *
 * @author Gerardo
 */
public class UsuarioFacade {
    private static Usuario usuario = new Usuario();
    private static String estado;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioFacade.usuario = usuario;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        UsuarioFacade.estado = estado;
    }
}
