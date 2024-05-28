/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_agregarProductoController implements Initializable {

     @FXML
    private Pane Pane;

    @FXML
    private ComboBox<String> comboCategoria;

    @FXML
    private TextField textColeccion;

    @FXML
    private TextArea textDescripcion;

    @FXML
    private TextField textPrecio;

    @FXML
    private TextField textnombre;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboCategoria.getItems().addAll("Sombrero","Bolso","Otros accesorios");
    }
    
    
    @FXML
    void event_guardar(ActionEvent event) {
        
        FabricaEntidad_sistema fabrica = new FabricaEntidad_sistema2();
        fabrica.RegistroProducto(
                textnombre.getText(), 
                "producto", 
                textDescripcion.getText(), 
                textColeccion.getText(), 
                comboCategoria.getValue(), 
                Integer.parseInt(textPrecio.getText()));
        
        // limpiamos los campos
        textnombre.setText("");
        textDescripcion.setText("");
        textColeccion.setText("");
        comboCategoria.setValue(null);
        textPrecio.setText("");

    }
    
}
