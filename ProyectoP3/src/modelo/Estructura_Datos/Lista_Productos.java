/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.Estructura_Datos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author USUARIO
 */
public class Lista_Productos {
    
   private List<Producto>  lista;
    
    public Lista_Productos(){
         lista = new ArrayList<>();
    }
    
    public void agregarProducto(Producto pro){
        
        lista.add(pro);
    }
    
    public List<Producto> getLista(){
        return lista;
    }
    
   public void setLista( List<Producto> lista){
       
       this.lista = lista;
   }
    
}
