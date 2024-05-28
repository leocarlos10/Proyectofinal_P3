/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_agregarProductoController implements Initializable {
    
    Stage stage1;
    
    public void setStage(Stage stage){
        this.stage1 = stage;
    }

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
    
    @FXML
    void event_agregarInfoP(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_agregar_P.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {

            System.out.println("Error en el cambio de ventana");
        }

    }

    @FXML
    void event_agregarfoto(ActionEvent event) {

    }
    
}
