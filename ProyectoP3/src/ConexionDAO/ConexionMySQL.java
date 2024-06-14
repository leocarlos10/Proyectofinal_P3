package ConexionDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements InterfaceConection {

    private static Connection con;

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String paswword = "";
    private static final String url = "jdbc:mysql://localhost/SGestion_I_P";

    public ConexionMySQL() {

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, paswword);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    @Override
    public Connection getConnection() {
        return con;
    }

    public void cerrar() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public void disconnect() {
        con = null;
    }

}
