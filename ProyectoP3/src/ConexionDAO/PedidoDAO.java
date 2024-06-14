package ConexionDAO;

import modelo.Pedido;

public class PedidoDAO implements DAO<Pedido> {

    private ConexionMySQL connection;

    public PedidoDAO(ConexionMySQL connection) {
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
