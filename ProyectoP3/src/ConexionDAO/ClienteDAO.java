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

            String query = "INSERT INTO Cliente (nombre, direccion, tipo_entidad, whatsapp, ciudad, pais, correo, metodoPago, telefono, id_pedido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getDireccion());
            statement.setString(3, cliente.getTipo_entidad());
            statement.setString(4, cliente.getWhatsapp());
            statement.setString(5, cliente.getCiudad());
            statement.setString(6, cliente.getPais());
            statement.setString(7, cliente.getCorreo());
            statement.setString(8, cliente.getMetodoPago());
            statement.setString(9, cliente.getTelefono());
            statement.setString(10, cliente.getId_pedido());
                  

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
    public void delete(int id) {
        
        
    }

    @Override
    public List<Cliente> get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
