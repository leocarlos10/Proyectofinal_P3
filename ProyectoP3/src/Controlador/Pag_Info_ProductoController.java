/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import ConexionDAO.ConexionMySQL;
import ConexionDAO.DAO;
import ConexionDAO.ProductoDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
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
public class Pag_Info_ProductoController implements Initializable {
    
    
    Producto producto;
    ConexionMySQL conexion;
    DAO<Producto> dao;
    Stage stage;
    TextField precio;
    TextField cantidad;
    TextField categoria;
    
    public void setProducto(Producto producto,Stage stage, TextField precio, TextField cantidad, TextField categoria ){
        
        this.producto = producto;
        this.stage = stage;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        CargarInfo();
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
        
    }    
    
    public void CargarInfo(){
        
        try {
            // cargamos la imagen
            Image image = new Image(new FileInputStream("src/imagenes_productos/"+producto.getNombre_imagen()));
            imagen.setImage(image);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar la imagen controlador info producto" + ex);
        }
        
        textnombre.setText(producto.getNombre());
        textPrecio.setText(String.valueOf(producto.getPrecio()));
        textDescripcion.setText(producto.getDescripcion());
        textColeccion.setText(producto.getColeccion());
        textCategoria.setText(producto.getCategoria());
        textCantidadunidades.setText(String.valueOf(producto.getCantidadUnidades()));
        textnombre.requestFocus();
        
        
        
    }
    
    @FXML
    void event_updateProducto(ActionEvent event) {

        try {
            conexion = new ConexionMySQL();
            dao = new ProductoDAO(conexion.getConnection());
            producto.setNombre(textnombre.getText());
            producto.setPrecio(Integer.parseInt(textPrecio.getText()));
            producto.setDescripcion(textDescripcion.getText());
            producto.setColeccion(textColeccion.getText());
            producto.setCategoria(textCategoria.getText());
            producto.setCantidadUnidades(Integer.parseInt(textCantidadunidades.getText()));
            // actualizamos los campos
            ActualizarTextfieldInventario();
            dao.update(producto);
            conexion.cerrar();
        } catch (SQLException e) {
            System.out.println("error al actualizar producto controller info producto"+e);
        }
        stage.close();
    }
    
    /*
    este metodo se encarga de actualizar los campos que esta en el 
    inventario.
    */
    
    public void ActualizarTextfieldInventario() {
        precio.setText(String.valueOf(textPrecio.getText()));
        cantidad.setText(textCantidadunidades.getText());
        categoria.setText(textCategoria.getText());
    }
}
