package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            String query = "INSERT INTO Producto (nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria, cantidadUnidades ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            statement = connection.prepareStatement(query);
            
            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setString(3, producto.getTipo_E_sistema());
            statement.setString(4, producto.getDescripcion());
            statement.setString(5, producto.getColeccion());
            statement.setString(6, producto.getCategoria());
            statement.setInt(7,  producto.getCantidadUnidades());

            statement.executeUpdate();
            connection.close();
            
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }

    }

    @Override
    public Producto read(String id) {
        
        Producto prod;
        
        try {
            PreparedStatement statement;
            String query = "SELECT * FROM Producto where id = ?";
            statement = connection.prepareStatement(query);
            
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            
           
            connection.close();
            
            
        } catch (Exception e) {
            System.out.println("Error al Leer producto: " + e.getMessage());
        }
        
        
        return null;
    }

    @Override
    public void update(Producto producto) {

    }

    @Override
    public void delete(String id) {

    }
}


