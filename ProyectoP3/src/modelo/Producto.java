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
    int cantidadUnidades;

    public Producto( String nombre, int precio, String tipo_E_sistema, String descripcion, String coleccion, String categoria, int cantidadUnidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo_E_sistema = tipo_E_sistema;
        this.descripcion = descripcion;
        this.coleccion = coleccion;
        this.categoria = categoria;
        this.cantidadUnidades = cantidadUnidades;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo_E_sistema() {
        return tipo_E_sistema;
    }

    public void setTipo_E_sistema(String tipo_E_sistema) {
        this.tipo_E_sistema = tipo_E_sistema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColeccion() {
        return coleccion;
    }

    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipo_E_sistema=" + tipo_E_sistema + ", descripcion=" + descripcion + ", coleccion=" + coleccion + ", categoria=" + categoria + ", cantidadUnidades=" + cantidadUnidades + '}';
    }

   

    
    

   
    
    

    
    
    
}
