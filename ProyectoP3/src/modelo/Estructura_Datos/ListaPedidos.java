/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estructura_Datos;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author USUARIO
 */
public class ListaPedidos {

    List<Pedido> lista;

    public ListaPedidos() {

        lista = new ArrayList<>();
    }

    public void setLista(List<Pedido> lista) {
        this.lista = lista;
    }

    public void agregarPedido(Pedido ped) {
        lista.add(ped);
    }

    public List<Pedido> getLista() {
        return lista;
    }
}
