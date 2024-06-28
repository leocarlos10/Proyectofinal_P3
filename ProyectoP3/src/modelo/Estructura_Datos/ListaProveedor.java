        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estructura_Datos;

import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

/**
 *
 * @author USUARIO
 */
public class ListaProveedor {
    
     List<Proveedor> lista;
     
     public ListaProveedor(){
         lista = new ArrayList<>();
     }

    public void setLista(List<Proveedor> lista) {
        this.lista = lista;
    }
    
    
    public void agregarProveedor(Proveedor pro){
        lista.add(pro);
    }
    
    public List<Proveedor> getLista(){
        return lista;
    }
    
}
