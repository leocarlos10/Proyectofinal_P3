/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Entidad_sistema {
    
    protected String id;
    protected String nombre;
    protected String tipo_E_sistema;

    public Entidad_sistema(String id, String nombre, String tipo_E_sistema) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_E_sistema = tipo_E_sistema;
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

    public String getTipo_E_sistema() {
        return tipo_E_sistema;
    }

    public void setTipo_E_sistema(String tipo_E_sistema) {
        this.tipo_E_sistema = tipo_E_sistema;
    }
    
    
    
}