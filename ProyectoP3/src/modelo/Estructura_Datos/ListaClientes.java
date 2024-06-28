/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estructura_Datos;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author USUARIO
 */
public class ListaClientes {
    
    List<Cliente> lista;
    
    public ListaClientes(){
        lista = new ArrayList<>();
    }
    
    
    public void agregarCliente(Cliente cli){
        lista.add(cli);
    }
    
    public List<Cliente> getLista(){
       return lista;
    }
}
