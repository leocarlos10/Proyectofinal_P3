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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;
import modelo.FabricaEntidad;
import modelo.FabricaEntidad2;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author Leocarlos ospina y caleb seña 
 */
public class Pag_AgregarPedidoController implements Initializable {
    
    String url_imagen;
    Producto producto;
    Stage stage;
    ConexionMySQL conexion;
    DAO<Producto> daoP;
    TextField LCantidad2;

    public void setElementos(String url, Producto producto,Stage stage, TextField LCantidad2){
        
        this.url_imagen = url;
        this.producto = producto;
        this.stage = stage;
        this.LCantidad2 = LCantidad2;
        CargarDatos();
        
    }
    
     @FXML
    private TextField InputDireccion;

    @FXML
    private TextField InputNombre;

    @FXML
    private ImageView imagen;

    @FXML
    private TextField inputCanidadU;

    @FXML
    private TextField inputCiudad;

    @FXML
    private TextField inputCorreo;

    @FXML
    private TextField inputFecha;

    @FXML
    private TextField inputMetodoPago;

    @FXML
    private TextField inputPais;

    @FXML
    private TextField inputTelefono;

    @FXML
    private TextField inputWhatsapp;
    
    @FXML
    private TextField input_id_pedido;
    
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
    
    public void CargarDatos() {

        try {
            // cargamos la imagen
            Image image = new Image(new FileInputStream(url_imagen));
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
        input_id_pedido.requestFocus();
    }
    
     @FXML
    void event_guardar(ActionEvent event)  {
        
         try{
             
             FabricaEntidad_sistema fabrica = new FabricaEntidad_sistema2();
             FabricaEntidad fabricaE = new FabricaEntidad2();
             
             try{
                 // agrego el pedido
                 fabrica.RegistroPedido(
                         input_id_pedido.getText(),
                         "pedido" ,
                         Integer.parseInt(inputCanidadU.getText()),
                         LocalDate.parse(inputFecha.getText()),
                         producto.getId());
                 
                 // agrego el cliente con su id relacionado
                 fabricaE.RegistroCliente(
                         InputNombre.getText(),
                         InputDireccion.getText(),
                         "cliente",
                         inputWhatsapp.getText(),
                         inputCiudad.getText(),
                         inputPais.getText(),
                         inputCorreo.getText(),
                         inputMetodoPago.getText(),
                         inputTelefono.getText(),
                         input_id_pedido.getText());
                 
             }catch(NumberFormatException e){
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                 alerta.setTitle("SUGERENCIA");
                 alerta.setContentText("Por favor revise que ningun campo este vacio"
                         + "Por favor revise que no este ingresando letras en campos que son para numeros"
                         + "Por favor revise que la fecha este bien escrita ");
                 alerta.show();
             }
             
             /*
             Como se agrego un pedido se debe eliminar 1 del atributo de CantidadUnidades.
             */
             int newCantidadUnidades = producto.getCantidadUnidades() - 1;
             LCantidad2.setText(String.valueOf(newCantidadUnidades));
             // seteamos el nuevo valor
             producto.setCantidadUnidades(newCantidadUnidades);
             
             // actualizamos el valor en la base de datos
             conexion = new ConexionMySQL();
             daoP = new ProductoDAO(conexion.getConnection());
             daoP.update(producto);
             conexion.cerrar();
             
             stage.close();
         }catch(SQLException e){
             System.out.println("error al actualizar cantidad"+e);
         }
    }
}
