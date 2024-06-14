package ConexionDAO;

import modelo.Proveedor;

public class ProveedorDAO implements DAO<Proveedor> {

    private ConexionMySQL connection;

    public ProveedorDAO(ConexionMySQL connection) {
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

}
