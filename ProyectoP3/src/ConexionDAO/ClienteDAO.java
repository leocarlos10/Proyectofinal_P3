package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

        Cliente cliente = new Cliente();

        try {

            String query = "SELECT * FROM cliente where id = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                cliente.setId(resultSet.getString("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTipo_entidad(resultSet.getString("tipo_entidad"));
                cliente.setWhatsapp(resultSet.getString("whatsapp"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setMetodoPago(resultSet.getString("metodoPago"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setId_pedido(resultSet.getString("id_pedido"));

            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al leer los pedidos" + e.getMessage());
        }

        return cliente;
    }

    @Override
    public void update(Cliente cliente) {
        try {
            PreparedStatement statement;
            String query = "UPDATE cliente SET "
                    + "id = ?,"
                    + "nombre = ?,"
                    + "direccion = ?,"
                    + "tipo_entidad = ?,"
                    + "whatsapp = ?,"
                    + "ciudad = ?,"
                    + "pais = ?,"
                    + "correo = ?,"
                    + "metodoPago = ?,"
                    + "telefono = ?,"
                    + "id_pedido = ?,"
                    + "WHERE = cliente.id = ?";

            statement = connection.prepareStatement(query);

            statement.setString(1, cliente.getId());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getDireccion());
            statement.setString(4, cliente.getTipo_entidad());
            statement.setString(5, cliente.getWhatsapp());
            statement.setString(6, cliente.getCiudad());
            statement.setString(7, cliente.getPais());
            statement.setString(8, cliente.getCorreo());
            statement.setString(9, cliente.getMetodoPago());
            statement.setString(10, cliente.getTelefono());
            statement.setString(11, cliente.getId_pedido());
            statement.setString(12, cliente.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el producto ");
        }

    }

    @Override
    public void delete(int id) {

        try {

            PreparedStatement statement;
            String query = "DELETE FROM cliente WHERE id = ? ";
            statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.execute();

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar cliente" + e.getMessage());
        }

    }

    @Override
    public List<Cliente> get() {

        List<Cliente> listaCliente = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getString("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTipo_entidad(resultSet.getString("tipo_entidad"));
                cliente.setWhatsapp(resultSet.getString("whatsapp"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setPais(resultSet.getString("pais"));
                cliente.setCorreo(resultSet.getString("correo"));
                cliente.setMetodoPago(resultSet.getString("metodoPago"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setId_pedido(resultSet.getString("id_pedido"));

                listaCliente.add(cliente);
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al traer los datos de la base de datos");
        }

        return listaCliente;
    }

}
