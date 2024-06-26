package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
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
        Pedido pedido = new Pedido();

        try {

            String query = "SELECT * FROM pedido where id = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()){
                pedido.setId(resultSet.getString("id"));
                pedido.setTipo_E_sistema(resultSet.getString("tipo_E_sistema"));
                pedido.setC_unidades(resultSet.getInt("C_unidades"));
                pedido.setFecha(resultSet.getDate("fecha").toLocalDate());
                pedido.setId(resultSet.getString("id_producto"));

            }
            
            statement.close();

        } catch (Exception e ){
            System.out.println("Error al leer los pedidos" + e.getMessage());
        }

        return pedido;
    }

    @Override
    public void update(Pedido pedido) {

        try {
            PreparedStatement statement;
            String query = "UPDATE pedido SET "
                + "id = ?,"
                + "tipo_E_sistema = ?,"
                + "C_unidades = ?,"
                + "fecha = ? ,"
                + "id_producto = ?"
                + "WHERE = pedido.id = ?"
            ;

            statement = connection.prepareStatement(query);

            statement.setString(1, pedido.getId());
            statement.setString(2, pedido.getTipo_E_sistema());
            statement.setInt(3, pedido.getC_unidades());
            statement.setDate(4, java.sql.Date.valueOf(pedido.getFecha()));
            statement.setInt(5, pedido.getId_producto());
            statement.setString(6, pedido.getId());

            statement.executeUpdate();
            statement.close();


        } catch (Exception e) {
            System.out.println("Error al actualizar el producto ");
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Pedido> get() {
        return null;
    }

}
