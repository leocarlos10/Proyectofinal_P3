/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author USUARIO
 */
public class Pag_InicioController implements Initializable {

    @FXML
    private Button btn_agregarproducto;
    
     @FXML
    private Button btnHClientes;

    @FXML
    private Button btnHProveedores;

    @FXML
    private Button btnHVenta;

    @FXML
    private StackPane stackPane;

    AnchorPane Pag_Inventario, Pag_Inicio_Imagenes, Pag_agregar_producto, Pag_Pedido,Pag_historiales;

    Pag_InventarioController controllerInventario;

    Pag_PedidoController controllerPedido;
    
    Pag_historialesController controller_historial;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Pag_Inventario = cargarVentanas("/vista/Pag_Inventario.fxml");
            Pag_Inicio_Imagenes = cargarVentanas("/vista/Pag_Inicio_Imagenes.fxml");
            Pag_agregar_producto = cargarVentanas("/vista/Pag_agregarProducto.fxml");
            Pag_Pedido = cargarVentanas("/vista/Pag_Pedido.fxml");
            Pag_historiales = cargarVentanas("/vista/Pag_historiales.fxml");
            stackPane.getChildren().addAll(Pag_Inicio_Imagenes, Pag_agregar_producto, Pag_Inventario, Pag_Pedido,Pag_historiales);

        } catch (Exception e) {
            System.out.println("error en el cambio de ventana" + e);
        }

        // controlamos la visibilidad de las ventanas
        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(true);
        Pag_Pedido.setVisible(false);
        Pag_historiales.setVisible(false);
    }

    @FXML
    void event_agregar_producto(ActionEvent event) {
        Pag_agregar_producto.setVisible(true);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(false);
         Pag_historiales.setVisible(false);
    }

    
    
    @FXML
    void event_Inventario(ActionEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(true);
        // necesito ejecuatar el metodo cargarProductos cada que cambie a la ventana inventario
        // esto con el objetivo de actualizar el inventario en caso de cualquier modificacion en los productos
        controllerInventario.cargarproductos();
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(false);
         Pag_historiales.setVisible(false);

    }

    @FXML
    void Event_Inicio(MouseEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(true);
        Pag_Pedido.setVisible(false);
        Pag_historiales.setVisible(false);

    }

    @FXML
    void event_mostrarPedidos(ActionEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(true);
        controllerPedido.cargarPedidos();
        Pag_historiales.setVisible(false);
        
    }
    
   
    
     @FXML
    void event_MostrarHistorial(ActionEvent event) {
        
         if (event.getSource().equals(btnHClientes)) {
             VisibilidadVentanasH();
             controller_historial.agregar_info_HClientes();
         } else if (event.getSource().equals(btnHVenta)) {
             VisibilidadVentanasH();
             controller_historial.agregar_info_Hventa();
         } else if (event.getSource().equals(btnHProveedores)) {
             VisibilidadVentanasH();
             controller_historial.agregar_info_HProveedores();
         }
    }
    
    public void VisibilidadVentanasH(){
        
            Pag_agregar_producto.setVisible(false);
            Pag_Inventario.setVisible(false);
            Pag_Inicio_Imagenes.setVisible(false);
            Pag_Pedido.setVisible(false);
            Pag_historiales.setVisible(true);
    }

    /*
    este metodo carga las ventanas del stakpane.
    y ademas tambien setea los controladores para poder utilizarlos despues
    @return La ventana cargada
     */
    private AnchorPane cargarVentanas(String url) throws Exception {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource(url));
        AnchorPane anchorPane = Loader.load();
        if (url.equalsIgnoreCase("/vista/Pag_Inventario.fxml")) {
            controllerInventario = Loader.getController();
        } else if (url.equalsIgnoreCase("/vista/Pag_Pedido.fxml")) {
            controllerPedido = Loader.getController();
        }else if(url.equalsIgnoreCase("/vista/Pag_historiales.fxml")) {
            controller_historial = Loader.getController();
        }
        return anchorPane;
    }

}
