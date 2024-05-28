/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.Estructura_Datos.ListaClientes;

/**
 *
 * @author jesuz319
 */
public class FabricaEntidad2 implements FabricaEntidad{
    
    

    @Override
    public void RegistroCliente(String nombre,
            String direccion,
            String tipo_entidad,
            String whatsapp,
            String ciudad,
            String pais,
            String correo,
            String metodoPago,
            String telefono){
      
        ListaClientes listaC = new ListaClientes();
        listaC.agregarCliente(new Cliente(nombre, direccion, whatsapp, ciudad, pais, correo, metodoPago, telefono));
    }
    
    @Override
    public void RegsitroProveedor(
            String nombre,
            String direccion,
            String tipo_entidad,
            String documento,
            String tipo_producto
    ){
        
    }
    

}
