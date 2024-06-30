/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.FabricaEntidad;
import modelo.FabricaEntidad2;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;
import modelo.Pedido;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_PedidoController implements Initializable {
    
    FabricaEntidad_sistema fabricaES;
    FabricaEntidad fabricaE;

    @FXML
    private FlowPane flowpane;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private FlowPane flowpaneModelo;

    @FXML
    private Label info_total_pedidos;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // indicamos que el flowpane sea responsive tanto en el width como como en el heigth.
        flowpane.prefWidthProperty().bind(scrollpane.widthProperty());
        flowpane.prefHeightProperty().bind(scrollpane.heightProperty());
        
        //Instancio las clases que se conectan con la DB
        fabricaES = new FabricaEntidad_sistema2();
        fabricaE = new FabricaEntidad2();
        
        if (flowpane.getChildren().isEmpty()) {
            cargarPedidos();
        }
        
    }
    
    public void cargarPedidos(){
        
        if(!flowpane.getChildren().isEmpty()){
             flowpane.getChildren().clear();
        }
        
        List<Pedido> lista =  fabricaES.ObtenerPedidos();
        // mandamos ala info de total de pedidos el tamaño de la lista 
        info_total_pedidos.setText(String.valueOf(lista.size()));
        
        for(Pedido i: lista){
            
            // recorremos la lista de pedidos y traemos los productos y los clientes realcionados el pedido
            Cliente cliente = fabricaE.obtenerCliente(i.getId_cliente());
            Producto producto = fabricaES.obtenerProducto(i.getId_producto());
            // ejecutamos el evento que carga los pedidos.
            loadPedidos(i,cliente,producto);
        } 
    }

    
    public void loadPedidos(Pedido pedido,Cliente cliente,Producto producto){
        
        // para la cajita de pedidos usamos un flowpane
        FlowPane flowpanebox = new FlowPane();
        // le agregamos dimensiones
        flowpanebox.setPrefSize(790, 80);
        // le agreagamos un estilo
        flowpanebox.getStyleClass().add("flowpanebox");
        
        /*
        dentro del flowpane van dos layouts 
        un gridPane para acomodar la informacion del pedido
        y un HBox para ubicar los botones de agregar venta, editar, Eliminar
        */
        GridPane grid = new GridPane();
        
        grid.setHgap(5); // Espaciado horizontal (entre columnas)
        grid.setVgap(5); // Espaciado vertical (entre filas)
        /*
        Dentro del gridPane en la primera fila van los labels de la info 
        del pedido 
        y en la segunda van unos textfield encargados de mostrar es info.
        */
        Label LId = new Label("ID");
        Label LcantidadU = new Label("Cantidad de Unidades");
        Label Lfecha = new Label("Fecha");
        Label Lcliente= new Label("Cliente");
        Label Lproducto = new Label("Producto");
        Label Lestado = new Label("Estado");
        
        // agregamos los labels al gridpane
        grid.add(LId, 0, 0);
        grid.add(LcantidadU, 1, 0);
        grid.add(Lfecha, 2, 0);
        grid.add(Lcliente, 3, 0);
        grid.add(Lproducto, 4, 0);
        grid.add(Lestado, 5, 0);
        
        // Creamos los TextField y botones para la fila de mostrar la información
        TextField id = new TextField(String.valueOf(pedido.getId()));
        TextField CantidadU = new TextField(String.valueOf(pedido.getC_unidades()));
        TextField fecha = new TextField(String.valueOf(pedido.getFecha()));
        // agregamos estilos a cada text
        setEstilosTextField(id,CantidadU,fecha);
        Button btncliente = new Button(cliente.getNombre());
        Button btnproducto = new Button(producto.getNombre());
        //agregamos los eventos
        evento_mostrarCliente(btncliente,cliente);
        evento_mostrarProducto(btnproducto,producto);
        ComboBox<String> estado = new ComboBox();
        evento_combo_estado(estado, pedido);
        // agregamos estilos a os buttons y a el comboBox
        setEstilosButton(btncliente, btnproducto);
        setEstilosCombo(estado,pedido);
        // agrego los elementos del combo
        estado.getItems().addAll("Pendiente","En Proceso","Enviado","Completado","Cancelado");
        
        // agregamos los text y buttons al grid
        grid.add(id, 0, 1);
        grid.add(CantidadU, 1, 1);
        grid.add(fecha, 2, 1);
        grid.add(btncliente, 3, 1);
        grid.add(btnproducto , 4, 1);
        grid.add(estado , 5, 1);
        
        // por ultimo agregamos el HBOX para el layout de botones
        HBox layoutbtn = new HBox();
        layoutbtn.setPrefSize(233, 59);
        layoutbtn.setSpacing(10);
        Button btnAgregarV = new Button("Agregar Venta");
        Button btnEditar = new Button("Editar");
        Button btnEliminar = new Button("Eliminar");
        setEstilosButton(btnAgregarV, btnEditar, btnEliminar);
        // agregamos los eventos a los botones
        evento_Eliminar_pedido(btnEliminar,Integer.parseInt(pedido.getId()));
        // agregamos los botones al layaoutbtn
        layoutbtn.getChildren().addAll(btnAgregarV,btnEditar,btnEliminar);
        
        //  agregamos el gridpane y layout pane al flowpane
        flowpanebox.getChildren().addAll(grid,layoutbtn);
        // por ultimo agremaos el flowpanebox al flowpane de la vista que contiene las cajitas de los pedidos
        flowpane.getChildren().addAll(flowpanebox);
    }
    
    public void evento_mostrarCliente(Button btncliente,Cliente cliente){
        
        btncliente.setOnAction(event->{
             try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_Info_Cliente.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                Pag_Info_ClienteController controller = loader.getController();
                controller.setCliente(cliente, stage, btncliente);
                stage.show();
            } catch (IOException e) {
                System.out.println("Error al cambiar la ventana info Producto" + e);
            }
            
        });
        
    }
    
     public void evento_mostrarProducto(Button btnproducto, Producto producto) {

        btnproducto.setOnAction(event -> {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_Info_Producto.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                Pag_Info_ProductoController controller = loader.getController();
                controller.setProducto(producto, stage);
                stage.show();
            } catch (IOException e) {
                System.out.println("Error al cambiar la ventana info Producto" + e);
            }
        });
    }
     
     public void evento_combo_estado(ComboBox<String> estado, Pedido pedido){
         
         estado.setOnAction(Event -> {
             
             String selectEstado = estado.getValue();
             pedido.setEstado(selectEstado);
             fabricaES.UpdatePedido(pedido);
         });
         
     }
     
      public void evento_Agregar_venta(Button btnAgregarventa){
         
         btnAgregarventa.setOnAction(event -> {
             
             
         });
         
     }
     
      public void evento_Editar_pedido(Button btnEditar){
         
         btnEditar.setOnAction(event -> {
             
             
         });
         
     }
     
     public void evento_Eliminar_pedido(Button btnEliminar,int id){
         
         btnEliminar.setOnAction(event -> {
             fabricaES.DeletePedido(id);
             cargarPedidos();
             
         });
         
     }
     
     public void setEstilosTextField(TextField text,TextField text2, TextField text3){
         
         text.getStyleClass().add("inputs");
         text2.getStyleClass().add("inputs");
         text3.getStyleClass().add("inputs");
     }
     
     public void setEstilosButton(Button btn1, Button btn2){
         
         btn1.getStyleClass().add("buttons");
         btn2.getStyleClass().add("buttons");
     }
     
     public void setEstilosButton(Button btn1, Button btn2,Button btn3){
         
         btn1.getStyleClass().add("buttons");
         btn2.getStyleClass().add("buttons");
         btn3.getStyleClass().add("buttons");
     }
     
    public void setEstilosCombo(ComboBox combo, Pedido pedido) {

        if (pedido.getEstado() != null) {
            combo.setPromptText(pedido.getEstado());
            combo.getStyleClass().add("comboBox");

        } else {
            combo.setPromptText("Estado");
            combo.getStyleClass().add("comboBox");
        }

    }
}
