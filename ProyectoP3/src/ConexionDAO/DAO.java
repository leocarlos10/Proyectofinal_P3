package ConexionDAO;

public interface DAO<T> {

    void create(T entity);
    T read(String id);
    void update(T entity);
    void delete(String id);

}


/*
            
    Documentacion
                                             
    InterfaceConection connection = new ConexionMySQL();

    ClienteDAO clienteDAO = new ClienteDAO(connection);

    // Uso del DAO
    clienteDAO.create(new Cliente("1", "Nombre", "Direccion", "Tipo Entidad", "Whatsapp", "Ciudad", "Pais", "Correo", "Metodo Pago", "Telefono"));
    Cliente cliente = clienteDAO.read("1");
    clienteDAO.update(new Cliente("1", "Nombre Actualizado", "Direccion Actualizada", "Tipo Entidad Actualizado", "Whatsapp Actualizado", "Ciudad Actualizada", "Pais Actualizado", "Correo Actualizado", "Metodo Pago Actualizado", "Telefono Actualizado"));
    clienteDAO.delete("1");

 */
