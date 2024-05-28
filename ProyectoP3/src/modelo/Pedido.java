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
public class Pedido  {
     
    String id;
    String nombre;
    int precio;
    String tipo_E_sistema;
    int C_unidades;
    LocalDate fecha;

    public Pedido(String id, String nombre, int precio, String tipo_E_sistema, int C_unidades, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo_E_sistema = tipo_E_sistema;
        this.C_unidades = C_unidades;
        this.fecha = fecha;
    }
    
    

   

  

   
    
    
}
