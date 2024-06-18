/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface FabricaEntidad_sistema {
    
    
    
  
   
   void RegistroProducto(
            String nombre,
            String tipo_E_sistema,
            String descripcion,
            String coleccion,
            String categoria,
            int precio,
            int cantidadUnidades);
   
   
   void RegistroPedido(
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha
   );
    
}
