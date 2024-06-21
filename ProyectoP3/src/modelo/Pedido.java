package modelo;

import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class Pedido {

    private String id;
    private String tipo_E_sistema;
    private int C_unidades;
    private LocalDate fecha;

    public Pedido(
            String tipo_E_sistema,
            int C_unidades,
            LocalDate fecha
    ) {
        this.tipo_E_sistema = tipo_E_sistema;
        this.C_unidades = C_unidades;
        this.fecha = fecha;
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

}
