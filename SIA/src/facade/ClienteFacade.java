/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.Cliente;

/**
 *
 * @author Pablo I
 */
public class ClienteFacade {
   private static Cliente cliente = new Cliente();
   private static String estado;
   
   public static Cliente getCliente(){
       return cliente;
   }
   
   public static void setCliente(Cliente cliente){
       ClienteFacade.cliente = cliente;
   }
   
   public static String getEstado(){
       return estado;
   }
   
   public static void setEstado(String estado){
       ClienteFacade.estado = estado;
   }
}
