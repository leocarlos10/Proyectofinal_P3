/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.List;
import modelo.Estructura_Datos.ListaPedidos;
import modelo.Estructura_Datos.Lista_Productos;
import ConexionDAO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jesuz319
 */
public class FabricaEntidad_sistema2 implements FabricaEntidad_sistema {

    private ConexionMySQL conexion;
    private DAO<Producto> daoPro;
    private DAO<Pedido> daoPed;

    @Override
    public void RegistroProducto(
            String nombre,
            String tipo_E_sistema,
            String descripcion,
            String coleccion,
            String categoria,
            int precio,
            int cantidadUnidades,
            String nombre_imagen) {

        try {
            // realizamos la conexion
            conexion = new ConexionMySQL();
            // instanciamos la clase que necesitamso para guardar el producto
            daoPro = new ProductoDAO(conexion.getConnection());
            // ejecutamos el metodo que crea el producto.
            daoPro.create(new Producto(nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria, cantidadUnidades,nombre_imagen));
            // cerramos la conexion.
            conexion.cerrar();

        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad_sistema2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error " + ex);
        }
    }

    @Override
    public List<Producto> ObtenerProductos() {
        
        Lista_Productos lista = null;
                
        try {
            // realizo la conexion
            conexion = new ConexionMySQL();
            
            // instancio la clase que necesito para obtener todos los productos
            daoPro = new ProductoDAO(conexion.getConnection());
            
            // instancio la lista que voy a utilizar para guardar los productos
            lista = new Lista_Productos();
            lista.setLista(daoPro.get());
            
            // cierro la conexion
            conexion.cerrar();
            
        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad_sistema2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return lista.getLista();
    }
    
    @Override
    public Producto obtenerProducto(int id) {
        conexion = new ConexionMySQL();
        daoPro = new ProductoDAO(conexion.getConnection());
        Producto pro = daoPro.read(id);
        try {
            conexion.cerrar();
        } catch (SQLException ex) {
            System.out.println("error al cerrar la conexion metodo obtener producto" + ex);
        }
        return pro;
    }

    @Override
    public void RegistroPedido(
            String id,
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha,
            int id_producto,
            int id_cliente
    ) {

        try {
            conexion = new ConexionMySQL();
            daoPed = new PedidoDAO(conexion.getConnection());
            daoPed.create(new Pedido(id, tipo_E_sistema, C_unidades, fecha, id_producto,id_cliente));
            conexion.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad_sistema2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error"+ex.getMessage());
        }

    }

    @Override
    public List<Pedido> ObtenerPedidos() {
        
         ListaPedidos lista = null;
                
        try {
            // realizo la conexion
            conexion = new ConexionMySQL();
            
            // instancio la clase que necesito para obtener todos los productos
            daoPed = new PedidoDAO(conexion.getConnection());
            
            // instancio la lista que voy a utilizar para guardar los productos
            lista = new ListaPedidos();
            lista.setLista(daoPed.get());
            
            // cierro la conexion
            conexion.cerrar();
            
        } catch (SQLException ex) {
            Logger.getLogger(FabricaEntidad_sistema2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return lista.getLista();
        
    }

   
}
