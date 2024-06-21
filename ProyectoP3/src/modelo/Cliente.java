package modelo;

/**
 *
 * @author USUARIO
 */
public class Cliente  {
    
    private String id;
    private String nombre;
    private String direccion;
    private String tipo_entidad;
    private String whatsapp;
    private String ciudad;
    private String pais;
    private String correo;  
    private String metodoPago;
    private String telefono;

    public Cliente( 
            String nombre, 
            String direccion, 
            String whatsapp, 
            String ciudad, 
            String pais, 
            String correo, 
            String metodoPago, 
            String telefono
    ) {
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.whatsapp = whatsapp;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.metodoPago = metodoPago;
        this.telefono = telefono;
    }

    public String getId() {
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

    
    
}
