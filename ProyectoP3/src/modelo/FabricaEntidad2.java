/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import ConexionDAO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesuz319
 */
public class FabricaEntidad2 implements FabricaEntidad{
    
    ConexionMySQL conexion;
    DAO<Proveedor> DaoP;
    DAO<Cliente> DaoC;
    
    

    @Override
    public void RegistroCliente(String nombre,
            String direccion,
            String tipo_entidad,
            String whatsapp,
            String ciudad,
            String pais,
            String correo,
            String metodoPago,
            String telefono,
            String id_pedido
    ){
        try {
            conexion = new ConexionMySQL();
            DaoC = new ClienteDAO(conexion.getConnection());
            DaoC.create(new Cliente(nombre, direccion, whatsapp, ciudad, pais, correo, metodoPago, telefono, id_pedido));
            conexion.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ex.getMessage());
        }
        
        
    }
    
    @Override
    public void RegsitroProveedor(
            String nombre,
            String direccion,
            String tipo_entidad,
            String documento,
            String tipo_producto,
            int precio_producto
    ){
       
        try {
            conexion = new ConexionMySQL();
            DaoP = new ProveedorDAO(conexion.getConnection());
            DaoP.create(new Proveedor(nombre, direccion, tipo_entidad, documento, tipo_producto, precio_producto));
            conexion.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ ex.getMessage());
        }
        
        
        
        
    }
    

}
