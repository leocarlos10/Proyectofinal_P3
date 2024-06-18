package ConexionDAO;

import java.sql.Connection;
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
}
