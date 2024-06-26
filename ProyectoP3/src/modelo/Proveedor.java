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

    public Proveedor(){}
    
    public Proveedor( 
            String nombre, 
            String direccion, 
            String tipo_entidad, 
            String documento, 
            String tipo_producto, 
            int precio_producto
    ) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo_entidad = tipo_entidad;
        this.documento = documento;
        this.tipo_producto = tipo_producto;
        this.precio_producto = precio_producto;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_entidad() {
        return tipo_entidad;
    }

    public void setTipo_entidad(String tipo_entidad) {
        this.tipo_entidad = tipo_entidad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }
    
    


}
