package modelo;

/**
 *
 * @author USUARIO
 */
public class Cliente {

    int id;
    String nombre;
    String direccion;
    String tipo_entidad;
    String whatsapp;
    String ciudad;
    String pais;
    String correo;
    String metodoPago;
    String telefono;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String direccion, String tipo_entidad, String whatsapp, String ciudad, String pais, String correo, String metodoPago, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo_entidad = tipo_entidad;
        this.whatsapp = whatsapp;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.metodoPago = metodoPago;
        this.telefono = telefono;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo_entidad() {
        return tipo_entidad;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipo_entidad(String tipo_entidad) {
        this.tipo_entidad = tipo_entidad;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
