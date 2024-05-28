/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Proveedor extends Entidad {
    
    protected String documento;
    protected String tipo_producto;

    public Proveedor(String documento, String tipo_producto, String id, String nombre, String direccion, String tipo_entidad) {
        super(id, nombre, direccion, tipo_entidad);
        this.documento = documento;
        this.tipo_producto = tipo_producto;
        
    }

   
    
    
    
    
}
