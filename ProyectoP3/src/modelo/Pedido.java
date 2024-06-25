package modelo;

import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class Pedido {

     String id;
     String tipo_E_sistema;
     int C_unidades;
     LocalDate fecha;
     int id_producto;
    

    public Pedido(
            String id,
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha,
            int id_producto
    ) {
        this.id = id;
        this.tipo_E_sistema = tipo_E_sistema;
        this.C_unidades = C_unidades;
        this.fecha = fecha;
        this.id_producto =id_producto;
    }

    public String getId() {
        return id;
    }

    public String getTipo_E_sistema() {
        return tipo_E_sistema;
    }

    public int getC_unidades() {
        return C_unidades;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

}
