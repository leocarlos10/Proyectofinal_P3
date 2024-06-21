/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Proveedor  {
    
    String id;
    String nombre;
    String direccion;
    String tipo_entidad;
    String documento;
    String tipo_producto;
    int precio_producto;

    public Proveedor( 
            
            String id, 
            String nombre, 
            String direccion, 
            String tipo_entidad, 
            String documento, 
            String tipo_producto, 
            int precio_producto
    ) {
        
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo_entidad = tipo_entidad;
        this.documento = documento;
        this.tipo_producto = tipo_producto;
        this.precio_producto = precio_producto;
    }


}
