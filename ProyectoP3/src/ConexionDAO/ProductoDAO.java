package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Producto;

public class ProductoDAO implements DAO<Producto> {

    private Connection connection;

    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Producto producto) {

        try {

            PreparedStatement statement;
            String query = "INSERT INTO productos (nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria) VALUES (?, ?, ?, ?, ?, ?)";
            
            statement = connection.prepareStatement(query);
            
            //statement.setString(1, producto.getNombre());
            //statement.setDouble(2, producto.getPrecio());
            //statement.setString(3, producto.getTipo_E_sistema());
            //statement.setString(4, producto.getDescripcion());
            //statement.setString(5, producto.getColeccion());
            //statement.setString(6, producto.getCategoria());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }

    }

    @Override
    public Producto read(String id) {

        return null;
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(String id) {

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


    DatabaseConnection connection = new MySQLConnection();
    ClienteDAO clienteDAO = new ClienteDAO(connection);

    // Uso del DAO
    clienteDAO.create(new Cliente("1", "Nombre", "Direccion", "Tipo Entidad", "Whatsapp", "Ciudad", "Pais", "Correo", "Metodo Pago", "Telefono"));
    Cliente cliente = clienteDAO.read("1");
    clienteDAO.update(new Cliente("1", "Nombre Actualizado", "Direccion Actualizada", "Tipo Entidad Actualizado", "Whatsapp Actualizado", "Ciudad Actualizada", "Pais Actualizado", "Correo Actualizado", "Metodo Pago Actualizado", "Telefono Actualizado"));
    clienteDAO.delete("1");

 */
