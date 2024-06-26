package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO implements DAO<Proveedor> {

    private Connection connection;

    public ProveedorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Proveedor proveedor) {

        try {

            PreparedStatement statement;

            String query = "INSERT INTO proveedor ( nombre,direccion,tipo_entidad,documento,tipo_producto,precio_producto ) VALUES (?, ?, ?, ?, ?, ?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getDireccion());
            statement.setString(3, proveedor.getTipo_entidad());
            statement.setString(4, proveedor.getDocumento());
            statement.setString(5, proveedor.getTipo_producto());
            statement.setInt(6, proveedor.getPrecio_producto());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar preveedor: " + e.getMessage());
        }

    }

    @Override
    public Proveedor read(String id) {

        Proveedor proveedor = new Proveedor();

        try {

            String query = "SELECT * FROM proveedor where id = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                proveedor.setId(resultSet.getString("id"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setDireccion(resultSet.getString("direccion"));
                proveedor.setTipo_entidad(resultSet.getString("tipo_entidad"));
                proveedor.setDocumento(resultSet.getString("documento"));
                proveedor.setTipo_producto(resultSet.getString("tipo_producto"));
                proveedor.setTipo_producto(resultSet.getString("precio_producto"));
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al leer los pedidos" + e.getMessage());
        }

        return proveedor;
    }

    @Override
    public void update(Proveedor proveedor) {
        try {
            PreparedStatement statement;
            String query = "UPDATE proveedor SET "
                    + "id = ?,"
                    + "nombre = ?,"
                    + "direccion = ?,"
                    + "tipo_entidad = ? ,"
                    + "documento = ? ,"
                    + "tipo_producto = ?,"
                    + "precio_producto = ?"
                    + "WHERE = proveedor.id = ?";

            statement = connection.prepareStatement(query);

            statement.setInt(1, Integer.parseInt(proveedor.getId()));
            statement.setString(2, proveedor.getNombre());
            statement.setString(3, proveedor.getDireccion());
            statement.setString(4, proveedor.getTipo_entidad());
            statement.setString(5, proveedor.getDocumento());
            statement.setString(6, proveedor.getTipo_entidad());
            statement.setInt(7, proveedor.getPrecio_producto());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el proveedor ");
        }
    }

    @Override
    public void delete(int id) {

        try {

            PreparedStatement statement;
            String query = "DELETE FROM proveedor WHERE id = ? ";
            statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.execute();

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar proveedor" + e.getMessage());
        }
    }

    @Override
    public List<Proveedor> get() {
        List<Proveedor> listaProveedor = new ArrayList<>();

        try {

            String sql = "SELECT * FROM proveedor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor();

                proveedor.setId(resultSet.getString("id"));
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setDireccion(resultSet.getString("direccion"));
                proveedor.setTipo_entidad(resultSet.getString("tipo_entidad"));
                proveedor.setDocumento(resultSet.getString("documento"));
                proveedor.setTipo_producto(resultSet.getString("tipo_producto"));
                proveedor.setTipo_producto(resultSet.getString("precio_producto"));

                listaProveedor.add(proveedor);
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al traer listaProveedor de la base de datos");
        }

        return listaProveedor;
    }

}
