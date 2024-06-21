package ConexionDAO;

import java.sql.Connection;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO implements DAO<Proveedor> {

    private Connection connection;

    public ProveedorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Proveedor proveedor) {
        
    }

    @Override
    public Proveedor read(String id) {
        
        return null;
    }

    @Override
    public void update(Proveedor proveedor) {
      

    }

    @Override
    public void delete(String id) {
       
    }

    @Override
    public List<Proveedor> get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
