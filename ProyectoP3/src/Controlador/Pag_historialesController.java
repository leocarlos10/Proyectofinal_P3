/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_historialesController implements Initializable {
    
    
    @FXML
    private Pane Pane_estadisticas;

    @FXML
    private FlowPane flowpane;
      @FXML
    private VBox VBox2;

    @FXML
    private VBox VBox3;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label_info1;

    @FXML
    private Label label_info3;

    @FXML
    private Label labelinfo2;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField textBuscar;

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flowpane.prefWidthProperty().bind(scrollpane.widthProperty());
        flowpane.prefHeightProperty().bind(scrollpane.heightProperty());
        
    }
    
    
    
    public void agregar_info_HClientes(){
        label_info1.setText("Total de clientes");
        VBox2.setVisible(false);
        VBox3.setVisible(false);
        textBuscar.setPromptText("Buscar cliente");
    }
    
    public void agregar_info_Hventa(){
        label_info1.setText("Total de ventas");
        VBox2.setVisible(true);
        VBox3.setVisible(true);
        textBuscar.setPromptText("Buscar venta");
    }
    
      public void agregar_info_HProveedores(){
        label_info1.setText("Total de proveedores");
        VBox2.setVisible(false);
        VBox3.setVisible(false);
        textBuscar.setPromptText("Buscar proveedor");
    }
      
      public void getEntidades(){
          
          
      }
    
    
    
}
