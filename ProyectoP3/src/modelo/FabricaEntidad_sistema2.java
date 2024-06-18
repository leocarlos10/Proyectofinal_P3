/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.List;
import modelo.Estructura_Datos.ListaPedidos;
import modelo.Estructura_Datos.Lista_Productos;

/**
 *
 * @author jesuz319
 */
public class FabricaEntidad_sistema2 implements FabricaEntidad_sistema{

   @Override
   public void RegistroProducto(
            String nombre,
            String tipo_E_sistema,
            String descripcion,
            String coleccion,
            String categoria,
            int precio,
            int cantidadUnidades){
       
       // instancio la clase lista para poder guardar cada producto en una lista
       Lista_Productos listaP = new Lista_Productos();
       //guardamos el producto en la lista
       listaP.agregarProducto(new Producto( nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria,cantidadUnidades));
   }
   
    
    @Override
   public void RegistroPedido(
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha
   ){
       
       ListaPedidos listapedidos = new ListaPedidos();
       listapedidos.agregarPedido(new Pedido(  tipo_E_sistema, C_unidades, fecha));
       
   }
}
