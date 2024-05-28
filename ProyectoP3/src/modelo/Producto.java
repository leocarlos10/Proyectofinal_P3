/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Producto extends Entidad_sistema {
    
    protected String descripcion;
    protected String coleccion;
    protected String categoria;

    public Producto(String descripcion, String coleccion, String categoria, String id, String nombre, int precio, String tipo_E_sistema) {
        super(id, nombre, precio, tipo_E_sistema);
        this.descripcion = descripcion;
        this.coleccion = coleccion;
        this.categoria = categoria;
    }
    
    

    
    
    
}
