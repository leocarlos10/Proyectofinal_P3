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
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author jesuz319
 */
public class FabricaEntidad_sistema2 implements FabricaEntidad_sistema {

    private ConexionMySQL conexion;
    private DAO<Producto> daoPro;

    @Override
    public void RegistroProducto(
            String nombre,
            String tipo_E_sistema,
            String descripcion,
            String coleccion,
            String categoria,
            int precio,
            int cantidadUnidades) {

        try {
            // realizamos la conexion
            conexion = new ConexionMySQL();
            // instanciamos la clase que necesitamso para guardar el producto
            daoPro = new ProductoDAO(conexion.getConnection());
            // ejecutamos el metodo que crea el producto.
            daoPro.create(new Producto(nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria, cantidadUnidades));
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
    public void RegistroPedido(
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha
    ) {

        ListaPedidos listapedidos = new ListaPedidos();
        listapedidos.agregarPedido(new Pedido(tipo_E_sistema, C_unidades, fecha));

    }
}
