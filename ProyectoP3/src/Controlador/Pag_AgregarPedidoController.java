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
import java.util.List;
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
import modelo.Cliente;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;
import modelo.FabricaEntidad;
import modelo.FabricaEntidad2;
import modelo.Pedido;
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
    void event_guardar(ActionEvent event) {

        try {

            FabricaEntidad_sistema fabrica = new FabricaEntidad_sistema2();
            FabricaEntidad fabricaE = new FabricaEntidad2();
            // antes de guardar el pedido y el cliente verificamos que el id sea diferente a 
            // a los id de los pedidos registrados en la DB
            boolean estadoPedido = Verf_ID(input_id_pedido.getText());
            boolean estadoCliente = Verf_ID_cliente(Integer.parseInt(input_id_pedido.getText()));
            /*
            si estado = true -> encontro un id igual 
            si estado = false -> no encontro ningun id igual
            */
            if (!estadoPedido) {
                
                if(!estadoCliente){
                     try {

                    // agrego el cliente con su id relacionado
                    fabricaE.RegistroCliente(
                            Integer.parseInt(input_id_pedido.getText()),
                            InputNombre.getText(),
                            InputDireccion.getText(),
                            "cliente",
                            inputWhatsapp.getText(),
                            inputCiudad.getText(),
                            inputPais.getText(),
                            inputCorreo.getText(),
                            inputMetodoPago.getText(),
                            inputTelefono.getText());

                    // agrego el pedido
                    fabrica.RegistroPedido(
                            input_id_pedido.getText(),
                            "pedido",
                            Integer.parseInt(inputCanidadU.getText()),
                            LocalDate.parse(inputFecha.getText()),
                            producto.getId(),
                            Integer.parseInt(input_id_pedido.getText()));

                } catch (NumberFormatException e) {
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
                }else{
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("SUGERENCIA");
                    alerta.setContentText("Ya existe un Cliente registrado con este id por favor ingrese uno distinto");
                    alerta.show();
                    input_id_pedido.setText("");
                    input_id_pedido.requestFocus();

                }
               

            }else{
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("SUGERENCIA");
                alerta.setContentText("Ya existe un pedido registrado con este id por favor ingrese uno distinto");
                alerta.show();

                input_id_pedido.setText("");
                input_id_pedido.requestFocus();
                
            }

        } catch (SQLException e) {
            System.out.println("error al actualizar cantidad" + e);
        }
    }
    
    public boolean Verf_ID(String id){
        
        boolean band=false;
        FabricaEntidad_sistema fabrica = new FabricaEntidad_sistema2();
        
        List<Pedido> listaP = fabrica.ObtenerPedidos();
        
        for(Pedido i:listaP){
            
            if(i.getId().equalsIgnoreCase(id)){
                
                band = true;
            }
        }
        return band;
    }
    
    public boolean Verf_ID_cliente(int id) {

        boolean band = false;
        FabricaEntidad fabrica2 = new FabricaEntidad2();
        List<Cliente> listaC = fabrica2.getClientes();

        for (Cliente i: listaC) {

            if (i.getId() == id) {

                band = true;
            }
        }
        return band;

    }
}
