/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author jesuz319
 */
public interface FabricaEntidad {
    
    Entidad RegistroEntidad(
            String nombre,
            String direccion,
            String tipo_entidad,
            String whatsapp,
            String ciudad,
            String pais,
            String correo,
            String metodoPago,
            String telefono,
            String documento,
            String tipo_producto,
            int precio);
    
}
