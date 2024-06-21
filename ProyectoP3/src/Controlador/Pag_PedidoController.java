/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_PedidoController implements Initializable {

     @FXML
    private FlowPane flowpane;

    @FXML
    private ScrollPane scrollpane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // indicamos que el flowpane sea responsive tanto en el width como como en el heigth.
        flowpane.prefWidthProperty().bind(scrollpane.widthProperty());
        flowpane.prefHeightProperty().bind(scrollpane.heightProperty());
    }    
    
}
