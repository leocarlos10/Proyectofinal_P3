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
import javafx.stage.Stage;

/**
 *
 * @author USUARIO
 */
public class Pag_InicioController implements Initializable {
    
       @FXML
    private Button btn_agregarproducto;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btn_agregarproducto.setCursor(Cursor.HAND);
    }
    
    @FXML
    void event_agregar_producto(ActionEvent event) {
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Pag_agregarProducto.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            
            System.out.println("Error en el cambio de ventana");
        }
    }
    
}
