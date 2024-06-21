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
    private StackPane stackPane;

    AnchorPane Pag_Inventario, Pag_Inicio_Imagenes, Pag_agregar_producto, Pag_Pedido;

    Pag_InventarioController controllerInventario;

    Pag_PedidoController controllerPedido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Pag_Inventario = cargarVentanas("/vista/Pag_Inventario.fxml");
            Pag_Inicio_Imagenes = cargarVentanas("/vista/Pag_Inicio_Imagenes.fxml");
            Pag_agregar_producto = cargarVentanas("/vista/Pag_agregarProducto.fxml");
            Pag_Pedido = cargarVentanas("/vista/Pag_Pedido.fxml");
            stackPane.getChildren().addAll(Pag_Inicio_Imagenes, Pag_agregar_producto, Pag_Inventario, Pag_Pedido);

        } catch (Exception e) {
            System.out.println("error en el cambio de ventana" + e);
        }

        // controlamos la visibilidad de las ventanas
        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(true);
        Pag_Pedido.setVisible(false);
    }

    @FXML
    void event_agregar_producto(ActionEvent event) {
        Pag_agregar_producto.setVisible(true);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(false);
    }

    @FXML
    void event_Inventario(ActionEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(true);
        // necesito ejecuatar el metodo cargarProductos cada que cambie a la ventana inventario
        controllerInventario.cargarproductos();
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(false);

    }

    @FXML
    void Event_Inicio(MouseEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(true);
        Pag_Pedido.setVisible(false);

    }

    @FXML
    void event_mostrarPedidos(ActionEvent event) {

        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(false);
        Pag_Pedido.setVisible(true);
    }

    /*
    este metodo carga las ventanas del stakpane.
    y ademas tambien setea los controladores para poder utilizarlos despues
    @return La ventana cargada
     */
    private AnchorPane cargarVentanas(String url) throws Exception {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource(url));
        AnchorPane pane = Loader.load();
        if (url.equalsIgnoreCase("/vista/Pag_Inventario.fxml")) {
            controllerInventario = Loader.getController();
        } else if (url.equalsIgnoreCase("/vista/Pag_Pedido.fxml")) {
            controllerPedido = Loader.getController();
        }
        return pane;
    }

}
