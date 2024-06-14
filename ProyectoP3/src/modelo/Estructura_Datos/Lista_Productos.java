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
    
    List<Producto>  lista = new ArrayList<>();
    
    public Lista_Productos(){
       
        lista.add(new Producto("sombrero tipo 2", 50000, "producto", "sombrero en fibra de caña flecha", "sombrero 19", "sombrero", 100));
        lista.add(new Producto("sombrero tipo 3", 60000, "producto", "sombrero en fibra de caña flecha", "sombrero 20", "sombrero", 100));
        lista.add(new Producto("sombrero tipo 4", 70000, "producto", "sombrero en fibra de caña flecha", "sombrero 121", "sombrero", 100));
        lista.add(new Producto("sombrero tipo 5", 80000, "producto", "sombrero en fibra de caña flecha", "sombrero 122", "sombrero", 100));
    }
    
    public void agregarProducto(Producto pro){
        
        lista.add(pro);
    }
    
    public List<Producto> getLista(){
        return lista;
    }
    
    public void mostrarDatos(){
        for(Producto i: lista){
            JOptionPane.showMessageDialog(null, i.toString());
        }
    }
    
}
