package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO implements DAO<Cliente> {
    private Connection connection;
    
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) {
        
         try {

            PreparedStatement statement;

            String query = "INSERT INTO Cliente (nombre, direccion, tipo_entidad, whatsapp, ciudad, pais, correo, metodoPago, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTipo_entidad());
            statement.setString(3, cliente.getWhatsapp());
            statement.setString(3, cliente.getCiudad());
            statement.setString(3, cliente.getPais());
            statement.setString(3, cliente.getCorreo());
            statement.setString(3, cliente.getMetodoPago());
            statement.setString(3, cliente.getTelefono());
                  

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }
        
    }

    @Override
    public Cliente read(String id) {
  
        return null;
    }

    @Override
    public void update(Cliente cliente) {

        
    }

    @Override
    public void delete(String id) {
        
        
    }

    @Override
    public List<Cliente> get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
