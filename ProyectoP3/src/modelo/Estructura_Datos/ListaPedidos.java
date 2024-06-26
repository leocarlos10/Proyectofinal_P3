/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estructura_Datos;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author USUARIO
 */
public class ListaPedidos {
    
     List<Pedido> lista = new ArrayList<>();
     
     
    
    
    public void agregarPedido(Pedido ped){
        lista.add(ped);
    }
    
    public List<Pedido> getLista(){
       return lista;
    }
}
