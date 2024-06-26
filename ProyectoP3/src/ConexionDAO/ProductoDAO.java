package ConexionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO implements DAO<Producto> {

    private Connection connection;

    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    /*
     * Este metodo es el encargado de guardar un producto en la base de datos
     * revise como parametro un producto
     * 
     * @param producto
     */
    @Override
    public void create(Producto producto) {

        try {

            PreparedStatement statement;

            String query = "INSERT INTO producto (nombre, precio, tipo_E_sistema, descripcion, coleccion, categoria, cantidadUnidades, nombre_imagenes) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, producto.getNombre());
            statement.setDouble(2, producto.getPrecio());
            statement.setString(3, producto.getTipo_E_sistema());
            statement.setString(4, producto.getDescripcion());
            statement.setString(5, producto.getColeccion());
            statement.setString(6, producto.getCategoria());
            statement.setInt(7, producto.getCantidadUnidades());
            statement.setString(8, producto.getNombre_imagen());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
        }

    }

    @Override
    public Producto read(String id) {

        Producto prod;

        try {

            String query = "SELECT * FROM Producto where id = ?";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                prod = new Producto();
                prod.setId(resultSet.getInt("id"));
                prod.setNombre(resultSet.getString("nombre"));
                prod.setPrecio(resultSet.getInt("precio"));
                prod.setTipo_E_sistema(resultSet.getString("tipo_E_sistema"));
                prod.setDescripcion(resultSet.getString("descripcion"));
                prod.setColeccion(resultSet.getString("coleccion"));
                prod.setCategoria(resultSet.getString("categoria"));
                prod.setCantidadUnidades(resultSet.getInt("cantidadUnidades"));
                prod.setNombre_imagen(resultSet.getString("nombre_imagenes"));
            
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al Leer producto: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void update(Producto producto) {

        try {

            PreparedStatement statement;
            String query = "UPDATE `producto` SET "
                    + "`id` = ?,"
                    + "`nombre` = ?, "
                    + "`precio` = ?, "
                    + "`tipo_E_sistema` = ?, "
                    + "`descripcion` = ?, "
                    + "`coleccion` = ?, "
                    + "`categoria` = ?, "
                    + "`cantidadUnidades` = ?, "
                    + "`nombre_imagenes` = ? WHERE `producto`.`id` = ? ";

            statement = connection.prepareStatement(query);

            statement.setInt(1, producto.getId());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getPrecio());
            statement.setString(4, producto.getTipo_E_sistema());
            statement.setString(5, producto.getDescripcion());
            statement.setString(6, producto.getColeccion());
            statement.setString(7, producto.getCategoria());
            statement.setInt(8, producto.getCantidadUnidades());
            statement.setString(9, producto.getNombre_imagen());
            statement.setInt(10, producto.getId());

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {

            System.out.println("error al actualizar la tabla producto" + e);
        }

    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement statement;
            String query = "DELETE FROM producto WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto" + e.getMessage());
        }
    }

    /*
     * Este metodo se encarga de traer todos los productos
     * de la base de datos
     * 
     * @return la lista de productos(listaPro)
     */
    @Override
    public List<Producto> get() {

        List<Producto> listaPro = new ArrayList<>();

        try {
            // creamos el sql
            String sql = "SELECT * FROM `producto`";
            // creamos el objeto statement
            Statement statement = connection.createStatement();
            // ejecutamos el sql.
            ResultSet resultado = statement.executeQuery(sql);

            // creamos un bucle que recorra la tabla y cree un objeto de tipo Producto
            // para finalmente agregarlo ala lista listaPro
            while (resultado.next()) {
                // creamos el objeto
                Producto producto = new Producto();
                producto.setId(resultado.getInt("id"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getInt("precio"));
                producto.setTipo_E_sistema(resultado.getString("tipo_E_sistema"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setColeccion(resultado.getString("coleccion"));
                producto.setCategoria(resultado.getString("categoria"));
                producto.setCantidadUnidades(resultado.getInt("cantidadUnidades"));
                producto.setNombre_imagen(resultado.getString("nombre_imagenes"));

                // guardamos el objeto en la lista
                listaPro.add(producto);
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error al traer los datos de la base de datos. " + e);
        }

        // retornamos la lista
        return listaPro;
    }
}
