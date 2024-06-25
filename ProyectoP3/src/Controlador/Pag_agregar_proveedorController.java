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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.FabricaEntidad;
import modelo.FabricaEntidad2;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_agregar_proveedorController implements Initializable {
    
    Stage stage;
    
     void setStage(Stage stage) {
        this.stage=stage;
    }

    @FXML
    private TextField textDireccion;

    @FXML
    private TextField textDocumento;

    @FXML
    private TextField textPrecio;

    @FXML
    private TextField textTipoProducto;

    @FXML
    private TextField textnombre;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    void event_guardar(ActionEvent event) {

        FabricaEntidad fabrica = new FabricaEntidad2();

        try {
            fabrica.RegsitroProveedor(
                    textnombre.getText(),
                    textDireccion.getText(),
                    "Proveedor",
                    textDocumento.getText(),
                    textTipoProducto.getText(),
                    Integer.parseInt(textPrecio.getText()));

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("SUGERENCIA");
            alerta.setContentText("Por favor revise que ningun campo este vacio");
            alerta.show();
        }
        
        stage.close();

    }

   
    
}
