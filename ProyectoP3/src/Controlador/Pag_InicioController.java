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
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USUARIO
 */
public class Pag_InicioController implements Initializable {

    @FXML
    private Button btn_agregarproducto;
    
     @FXML
    private StackPane stackPane;
    
    AnchorPane Pag_Inventario, Pag_Inicio_Imagenes,Pag_agregar_producto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            Pag_Inventario = cargarVentanas("/vista/Pag_Inventario.fxml");
            Pag_Inicio_Imagenes = cargarVentanas("/vista/Pag_Inicio_Imagenes.fxml");
            Pag_agregar_producto = cargarVentanas("/vista/Pag_agregarProducto.fxml");
            stackPane.getChildren().addAll(Pag_Inicio_Imagenes,Pag_agregar_producto,Pag_Inventario);

        } catch (Exception e) {
            System.out.println("error en el cambio de ventana" + e);
        }
        
        // controlamos la visibilidad de las ventanas
        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(true);
    }

    @FXML
    void event_agregar_producto(ActionEvent event) {
        Pag_agregar_producto.setVisible(true);
        Pag_Inventario.setVisible(false);
        Pag_Inicio_Imagenes.setVisible(false);
    }

    @FXML
    void event_Inventario(ActionEvent event) {
        
        Pag_agregar_producto.setVisible(false);
        Pag_Inventario.setVisible(true);
        Pag_Inicio_Imagenes.setVisible(false);

    }
    
     @FXML
    void Event_Inicio(MouseEvent event) {
         Pag_agregar_producto.setVisible(false);
         Pag_Inventario.setVisible(false);
         Pag_Inicio_Imagenes.setVisible(true);


    }
    
    // este metodo carga las ventanas del stakpane.
    private AnchorPane cargarVentanas(String url) throws Exception{
        return  FXMLLoader.load(getClass().getResource(url));
    }

}
