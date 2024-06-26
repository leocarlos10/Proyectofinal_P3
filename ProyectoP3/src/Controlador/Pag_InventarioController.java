/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import ConexionDAO.ConexionMySQL;
import ConexionDAO.DAO;
import ConexionDAO.ProductoDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_InventarioController implements Initializable {
   
    FabricaEntidad_sistema fabrica;
    ConexionMySQL conexion;
    DAO<Producto> dao;
    Producto producto;

    @FXML
    private FlowPane flowPane;

    @FXML
    private ScrollPane scrollPane;

    ImageView imagen;

    @FXML
    private SplitMenuButton filtro;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // esto hace que el flowpane dentro del scroll pane sea responsive es decir se ajuste ala panatalla
        flowPane.prefWidthProperty().bind(scrollPane.widthProperty());
        flowPane.prefHeightProperty().bind(scrollPane.heightProperty());
        // configuramos la orientacion del flowpane
        flowPane.setOrientation(Orientation.HORIZONTAL);
        /* 
         fabricaEntidad_sistema es una clase que tiene un metodo
         obtenerProductos() que retorna la lista de productos 
         que fue extraida de la base de datos.
         */
        fabrica = new FabricaEntidad_sistema2();
        if (flowPane.getChildren().isEmpty()) {
            cargarproductos();
        }

        // agrego el evento al SplitMenuButton.
        event_cargar_todo();
        
    }
    
    public void cargarproductos(){
        
        if(!flowPane.getChildren().isEmpty()){
             flowPane.getChildren().clear();
        }
       
        List<Producto> lista = fabrica.ObtenerProductos();

        for (int i = 0; i < lista.size(); i++) {
            loadproductos(
                    "src/imagenes_productos/"+lista.get(i).getNombre_imagen(),
                    lista.get(i));
        }
    }

    private void loadproductos(String url_Imagen, Producto producto) {
        
        // creamos un nuevo VBox
        VBox newVBox = new VBox();
        //le agregamos el estilo
        newVBox.getStyleClass().add("Vbox");
        // alineamos los elementos
        newVBox.setAlignment(Pos.TOP_CENTER);
        //dimensiones del VBox
        newVBox.setPrefWidth(249);
        newVBox.setPrefHeight(241);

        // agregamos el nombre
        Label Lnombre = new Label(producto.getNombre());
        Dimensiones_EstiloLabels(Lnombre);

        // layaout gridPane para agregar la informacion
        GridPane layout = new GridPane();
        layout.setHgap(5); // Espaciado horizontal (entre columnas)
        layout.setVgap(5); // Espaciado vertical (entre filas)
        layout.setPadding(new Insets(5, 2, 5, 5));

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.CENTER);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.CENTER);

        ColumnConstraints col3 = new ColumnConstraints();
        col2.setHalignment(HPos.CENTER);

        layout.getColumnConstraints().addAll(col1, col2, col3);

        // labels de informacion
        Label Lprecio = new Label("precio");

        Label Lcategoria = new Label("Categoria");

        Label LCantidad = new Label("Cantidad");

        // agregamos los labels al gridpane
        layout.add(Lcategoria, 0, 0);
        layout.add(Lprecio, 1, 0);
        layout.add(LCantidad, 2, 0);

        // textField para mostrar informacion y editar informacion
        TextField Lprecio2 = new TextField(String.valueOf(producto.getPrecio()));
        Dimensiones_EstiloTextfield(Lprecio2);
        TextField Lcategoria2 = new TextField(producto.getCategoria());
        // El textfield Lcoleccion2 lleva un estilo especifico
        Lcategoria2.setPrefSize(100, 17);
        Lcategoria2.getStyleClass().add("inputs");
        TextField LCantidad2 = new TextField(String.valueOf(producto.getCantidadUnidades()));
        Dimensiones_EstiloTextfield(LCantidad2);

        // agreamos los textfield al gridpane
        layout.add(Lcategoria2, 0, 1);
        layout.add(Lprecio2, 1, 1);
        layout.add(LCantidad2, 2, 1);
        
        //creamos la imagen
        imagen = new ImageView();
        try {
            Image image = new Image(new FileInputStream(url_Imagen));
            imagen.setImage(image);
            imagen.setFitWidth(125);
            imagen.setFitHeight(122);
            
            // agregamos el evento para que muestre la info completa del producto
            imagen.addEventHandler(MouseEvent.MOUSE_CLICKED, event->{
                mostrarInfoCompletaPro(producto, Lprecio2,LCantidad2,Lcategoria2); 
            });

        } catch (FileNotFoundException e) {
            System.out.println("imagen no encontrada");
        }
        
        // creamos el layaout para los botones de abajo de la caja
        HBox layoutbtn = new HBox();
        layoutbtn.getStyleClass().add("Layoutbtn");
        // botones
        Button AgregarP = new Button("Agregar pedido");
        AgregarP.getStyleClass().add("buttons");
        // agregamos el evento
        EventoAgregarPedido(AgregarP, url_Imagen, LCantidad2);
       
        Button Eliminar = new Button("Eliminar ");
        Eliminar.getStyleClass().add("buttons");
        // agregamos el evento
        EventoEliminarProducto(Eliminar);

        Button Editar = new Button("Editar");
        Editar.getStyleClass().add("buttons");
        // agregamos el evento
        EventoEditarProducto(Editar, Lprecio2, LCantidad2); 

        // agrego los botones al layaoutbtn
        layoutbtn.getChildren().addAll(AgregarP, Eliminar, Editar);

        newVBox.getChildren().addAll(Lnombre, imagen, layout, layoutbtn);
        // agregamos el nuevo elemento al flowpane
        flowPane.getChildren().add(newVBox);
        
         // por ultimo seteo el producto para poder luego
        // realizar los editar y guardar individualmente
        this.producto = producto;
    }
    
    // Eventos de la cajita del producto
    
    public void EventoAgregarPedido(Button Agregarpedido,String url_Imagen, TextField LCantidad2){
        
         Agregarpedido.setOnAction((ActionEvent event) -> {

            if (!(producto.getCantidadUnidades() == 0)) {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_AgregarPedido.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    Pag_AgregarPedidoController controller = loader.getController();
                    controller.setElementos(url_Imagen, producto, stage, LCantidad2);
                    stage.show();

                } catch (IOException ex) {
                    System.out.println("error " + ex);
                }

            } else {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("SUGERENCIA");
                alerta.setContentText("Producto Agotado");
                alerta.show();
            }

        });
        
    }
    
    public void EventoEliminarProducto( Button Eliminar){
        
         Eliminar.setOnAction(event -> {
            // realizamos la conexion 
            conexion = new ConexionMySQL();
            // instanciamos la clase ProductoDao
            dao = new ProductoDAO(conexion.getConnection());
            // eliminamos el producto de la DB
            dao.delete(producto.getId());

            cerrarConexion();
            // eliminamos la imagen del fichero
            liberar_recursos();
            cargarproductos();
            if (eliminarImagen_Producto(producto.getNombre_imagen())) {
                System.out.println("La imagen se elimino corectamente");
            } else {
                System.out.println("La imagen no se elimino.");
            }

        });

    }
    
    public void EventoEditarProducto(Button Editar,TextField Lprecio2,TextField LCantidad2){
        
         Editar.setOnAction(event -> {

            String Estado = Editar.getText();
            if (Estado.equalsIgnoreCase("editar")) {
                Lprecio2.setText("");
                LCantidad2.setText("");
                Lprecio2.requestFocus();
                Editar.setText("Guardar");
            } else if (Estado.equalsIgnoreCase("guardar")) {
                producto.setPrecio(Integer.parseInt(Lprecio2.getText()));
                producto.setCantidadUnidades(Integer.parseInt(LCantidad2.getText()));
                conexion = new ConexionMySQL();
                dao = new ProductoDAO(conexion.getConnection());
                dao.update(producto);
                cerrarConexion();
                Editar.setText("Editar");
            }
        });
        
    }
    
    public void mostrarInfoCompletaPro(Producto producto,TextField precio, TextField cantidad, TextField categoria){
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_Info_Producto.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            Pag_Info_ProductoController controller = loader.getController();
            controller.setProducto(producto,stage,precio,cantidad,categoria);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar la ventana" +e);
        }
        
    }

    private boolean eliminarImagen_Producto(String nombreImagen) {

        String rutaimagen = "src/imagenes_productos/" + nombreImagen;
        File imagen2 = new File(rutaimagen);

        if (!imagen2.exists()) {
            System.out.println("El archivo no existe: " + rutaimagen);
        }

        if (!imagen2.isFile()) {
            System.out.println("No es un archivo válido: " + rutaimagen);
        }

        if (!imagen2.canWrite()) {
            System.out.println("No se tienen permisos para eliminar el archivo: " + rutaimagen);
        }

        return imagen2.delete();
    }

    private void liberar_recursos() {
        imagen.setImage(null);
        imagen = null;

    }

    private void Dimensiones_EstiloTextfield(TextField text) {

        //dimensiones del label
        text.setPrefSize(85, 17);
        // estilo
        text.getStyleClass().add("inputs");

    }

    private void Dimensiones_EstiloLabels(Label label) {

        //dimensiones del label
        label.setPrefSize(113, 17);
        // estilo
        label.getStyleClass().add("Labels");

    }

    private void cerrarConexion() {

        try {
            conexion.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Pag_InventarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // eventos para filtrar
    @FXML
    void event_filtrar_bolso(ActionEvent event) {

        flowPane.getChildren().clear();
        List<Producto> lista = fabrica.ObtenerProductos();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoria().equalsIgnoreCase("Bolso")) {
                loadproductos(
                        "src/imagenes_productos/" + lista.get(i).getNombre_imagen(),
                        lista.get(i));
            }
        }
    }

    @FXML
    void event_filtrar_otros(ActionEvent event) {

        flowPane.getChildren().clear();
        List<Producto> lista = fabrica.ObtenerProductos();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoria().equalsIgnoreCase("Otros")) {
                loadproductos(
                        "src/imagenes_productos/" + lista.get(i).getNombre_imagen(),
                        lista.get(i));
            }
        }

    }

    @FXML
    void event_filtrar_sombrero(ActionEvent event) {

        flowPane.getChildren().clear();
        List<Producto> lista = fabrica.ObtenerProductos();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCategoria().equalsIgnoreCase("Sombrero")) {
                loadproductos(
                        "src/imagenes_productos/" + lista.get(i).getNombre_imagen(),
                        lista.get(i));
            }
        }
    }

    /*
    Cuando el SplitMenuButton se desenfoca se deben cargar todos 
    los productos de nuevo en el flowpane.
     */
    public void event_cargar_todo() {

        filtro.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                cargarproductos();
            }
        });
    }
}
