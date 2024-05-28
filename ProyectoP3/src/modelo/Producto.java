/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Producto  {
     
    String id;
    String nombre;
    int precio;
    String tipo_E_sistema;
    String descripcion;
    String coleccion;
    String categoria;

    public Producto( String nombre, int precio, String tipo_E_sistema, String descripcion, String coleccion, String categoria) {
        
        this.nombre = nombre;
        this.precio = precio;
        this.tipo_E_sistema = tipo_E_sistema;
        this.descripcion = descripcion;
        this.coleccion = coleccion;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo_E_sistema=" + tipo_E_sistema + ", descripcion=" + descripcion + ", coleccion=" + coleccion + ", categoria=" + categoria + '}';
    }
    
    

   
    
    

    
    
    
}
