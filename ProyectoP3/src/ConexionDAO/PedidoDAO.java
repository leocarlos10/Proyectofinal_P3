package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.Pedido;

public class PedidoDAO implements DAO<Pedido> {

    private Connection connection;

    public PedidoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Pedido pedido) {

        try {

            PreparedStatement statement;

            String query = "INSERT INTO pedido ( id, tipo_E_sistema, C_unidades, fecha, id_producto) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, pedido.getId());
            statement.setString(2, pedido.getTipo_E_sistema());
            statement.setInt(3, pedido.getC_unidades());
            statement.setDate(4, java.sql.Date.valueOf(pedido.getFecha()));
            statement.setInt(5, pedido.getId_producto());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar pedido: " + e);
        }

    }

    @Override
    public Pedido read(String id) {

        return null;
    }

    @Override
    public void update(Pedido pedido) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Pedido> get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
