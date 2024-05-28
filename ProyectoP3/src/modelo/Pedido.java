/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class Pedido extends Entidad_sistema {
    
    int C_unidades;
    int precio;
    LocalDate fecha;

    public Pedido(int C_unidades, int precio, LocalDate fecha, String id, String nombre, String tipo_E_sistema) {
        super(id, nombre, tipo_E_sistema);
        this.C_unidades = C_unidades;
        this.precio = precio;
        this.fecha = fecha;
    }

   
    
    
}
