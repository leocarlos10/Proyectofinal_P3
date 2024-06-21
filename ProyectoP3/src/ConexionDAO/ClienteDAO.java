package ConexionDAO;

import java.sql.Connection;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO implements DAO<Cliente> {
    private Connection connection;
    
    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) {
   
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
