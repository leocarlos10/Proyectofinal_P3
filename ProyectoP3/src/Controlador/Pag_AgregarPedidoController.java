/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_AgregarPedidoController implements Initializable {
    
    String url;
    Producto producto;
    Stage stage;

    public void setElementos(String url, Producto producto,Stage stage){
        
        this.url = url;
        this.producto = producto;
        this.stage = stage;
        
    }
    
       @FXML
    private ImageView imagen;

    @FXML
    private TextField textCantidadunidades;

    @FXML
    private TextField textCategoria;

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
        CargarDatos();
    } 
    
    public void CargarDatos() {

        try {
            // cargamos la imagen
            Image image = new Image(new FileInputStream(url));
            imagen.setImage(image);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar la imagen" + ex);
        }
        
        // cargamos la informacion de el producto seleccionado
        textnombre.setText(producto.getNombre());
        textColeccion.setText(producto.getColeccion());
        textDescripcion.setText(producto.getDescripcion());
        textPrecio.setText(String.valueOf(producto.getPrecio()));
        textCantidadunidades.setText(String.valueOf(producto.getCantidadUnidades()));
        textCategoria.setText(producto.getCategoria());
    }
    
     @FXML
    void event_guardar(ActionEvent event) {
        
        // agregar losgica para guardar el pedido
        stage.close();
    }
}
