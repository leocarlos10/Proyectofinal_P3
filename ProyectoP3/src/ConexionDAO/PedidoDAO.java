package ConexionDAO;

import java.sql.Connection;
import java.util.List;
import modelo.Pedido;

public class PedidoDAO implements DAO<Pedido> {

    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pedido pedido) {
        
    }

    @Override
    public Pedido read(String id) {
        
        return null;
    }

    @Override
    public void update(Pedido pedido) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public List<Pedido> get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
