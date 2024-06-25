package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO implements DAO<Proveedor> {

    private Connection connection;

    public ProveedorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Proveedor proveedor) {
        
        try {
            
            PreparedStatement statement;

            String query = "INSERT INTO proveedor ( nombre,direccion,tipo_entidad,documento,tipo_producto,precio_producto ) VALUES (?, ?, ?, ?, ?, ?)";

            
            statement = connection.prepareStatement(query);
            
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getDireccion());
            statement.setString(3, proveedor.getTipo_entidad());
            statement.setString(4, proveedor.getDocumento());
            statement.setString(5, proveedor.getTipo_producto());
            statement.setInt(6, proveedor.getPrecio_producto());

            statement.executeUpdate();
            statement.close();

            
        } catch (SQLException e) {
            System.out.println("Error al insertar preveedor: " + e.getMessage());
        }
        
    }

    @Override
    public Proveedor read(String id) {
        
        return null;
    }

    @Override
    public void update(Proveedor proveedor) {
      

    }

    @Override
    public void delete(int id) {
       
    }

    @Override
    public List<Proveedor> get() {
        return null;
    }

    

}
