/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Cliente extends Entidad {
    
    String whatsapp;
    String ciudad;
    String pais;
    String correo;
    String metodoPago;
    String telefono;

    public Cliente(String whatsapp, String ciudad, String pais, String correo, String metodoPago, String telefono, String id, String nombre, String direccion, String tipo_entidad) {
        super(id, nombre, direccion, tipo_entidad);
        this.whatsapp = whatsapp;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.metodoPago = metodoPago;
        this.telefono = telefono;
    }
    
    

    
    
    
    
}
