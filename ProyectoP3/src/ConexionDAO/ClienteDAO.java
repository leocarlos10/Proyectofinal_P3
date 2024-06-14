package ConexionDAO;

import java.sql.Connection;
import modelo.Cliente;

public class ClienteDAO implements DAO<Cliente> {
    private ConexionMySQL connection;
    
    public ClienteDAO(ConexionMySQL connection) {
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
}
