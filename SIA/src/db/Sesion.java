/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entidades.Usuario;

/**
 *
 * @author Gerardo
 * 11/11/2017
 */
public class Sesion {

    private static  Usuario usuario;
    //Patron de diseño para una sesion
    public final void persistir(Usuario u){
         usuario = u;
    }
    //Geter
    public String obtenerUsuario(){
        return usuario.getUsuario();
    }
}
