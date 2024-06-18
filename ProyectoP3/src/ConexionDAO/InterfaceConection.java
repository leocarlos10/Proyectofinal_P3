package ConexionDAO;

import java.sql.Connection;

public interface InterfaceConection {
    
    Connection getConnection();
    void disconnect();

}