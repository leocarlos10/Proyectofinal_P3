package ConexionDAO;

import java.util.List;
import modelo.Producto;
import modelo.Cliente; 
import modelo.Pedido;
import modelo.Proveedor;


public class ProductoBD {

    public void insertarCliente( List<Cliente> clientes ) {
    }
    
    
    public void insertarPedidos( List<Pedido> pedidos ){
    
    }
    
    public void insertarProveedor( List <Proveedor> proveedores ){
    
    }
    
    public void insertarProductos( List <Producto> productos ){
        
    } 
       
}

/*

Cliente:
    String id;
    String nombre;
    String direccion;
    String tipo_entidad;
    String whatsapp;
    String ciudad;
    String pais;
    String correo;
    String metodoPago;
    String telefono;

Pedido: 
    String id;
    String nombre;
    int precio;
    String tipo_E_sistema;
    int C_unidades;
    LocalDate fecha;

Proveedor 
    String id;
    String nombre;
    String direccion;
    String tipo_entidad;
    String documento;
    String tipo_producto;
    int precio_producto;

Producto: 
    String id;
    String nombre;
    int precio;
    String tipo_E_sistema;
    String descripcion;
    String coleccion;
    String categoria;

 */
