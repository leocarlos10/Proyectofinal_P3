/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Entidad {
    
    protected String id;
    protected String nombre;
    protected String direccion;
    protected String tipo_entidad;

    public Entidad(String id, String nombre, String direccion, String tipo_entidad) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo_entidad = tipo_entidad;
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
    
    
    
}
