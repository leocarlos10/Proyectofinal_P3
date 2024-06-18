/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Estructura_Datos.Lista_Productos;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_InventarioController implements Initializable {
    
     // accediendo ala lista de productos para cargar los productos
    Lista_Productos lista_p = new Lista_Productos();


     @FXML
    private FlowPane flowPane;
     
    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // esto hace que el flowpane dentro del scroll pane sea responsive es decir se ajuste ala panatalla
        flowPane.prefWidthProperty().bind(scrollPane.widthProperty());
        flowPane.prefHeightProperty().bind(scrollPane.heightProperty());
        // configuramos la orientacion del flowpane
        flowPane.setOrientation(Orientation.HORIZONTAL);
        // luego procedemos a subir los produtos al inventario
        for(int i=0;i<lista_p.getLista().size();i++){
            loadproductos(
                    "src/imagenes/imagen2.jpg",
                    lista_p.getLista().get(i).getNombre(),
                    String.valueOf(lista_p.getLista().get(i).getPrecio()),
                    lista_p.getLista().get(i).getCategoria(),
                    String.valueOf(lista_p.getLista().get(i).getCantidadUnidades()),
                    lista_p.getLista().get(i)
            );
        }
    }
    
    private void loadproductos(String url_Imagen,String nombre,String precio,String Categoria,String CUnidadades, Producto producto){
        
        // creamos un nuevo VBox
        VBox newVBox = new VBox();
        //le agregamos el estilo
        newVBox.getStyleClass().add("Vbox");
        // alineamos los elementos
        newVBox.setAlignment(Pos.TOP_CENTER);
        //dimensiones del VBox
        newVBox.setPrefWidth(245);
        newVBox.setPrefHeight(239);
        
        // agregamos el nombre
        Label Lnombre = new Label(nombre);
        Dimensiones_EstiloLabels(Lnombre);
        
        //creamos la imagen
        ImageView imagen = new ImageView();
        try{
             Image image = new Image(new FileInputStream(url_Imagen));
            imagen.setImage(image);
            imagen.setFitWidth(125);
            imagen.setFitHeight(122);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "imagen no encontrada");
        }
        
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

        layout.getColumnConstraints().addAll(col1, col2,col3);

        // labels de informacion
        Label Lprecio = new Label("precio");
        
        Label Lcategoria = new Label("Categoria");
        
        Label LCantidad = new Label("Cantidad");
        
        // agregamos los labels al gridpane
        layout.add(Lcategoria, 0, 0);
        layout.add(Lprecio, 1, 0);
        layout.add(LCantidad, 2, 0);
        
        // textField para mostrar informacion y editar informacion
        TextField Lprecio2 = new TextField(precio);
        Dimensiones_EstiloTextfield(Lprecio2);
        TextField Lcategoria2 = new TextField(Categoria);
        // El textfield Lcoleccion2 lleva un estilo especifico
        Lcategoria2.setPrefSize(100, 17);
        Lcategoria2.getStyleClass().add("inputs");
        TextField LCantidad2 = new TextField(CUnidadades);
        Dimensiones_EstiloTextfield(LCantidad2);
         
         // agreamos los textfield al gridpane
         layout.add(Lcategoria2, 0, 1);
         layout.add(Lprecio2, 1, 1);
         layout.add(LCantidad2, 2, 1);
         
         HBox layoutbtn = new HBox();
         layoutbtn.getStyleClass().add("Layoutbtn");
        // botones
        Button AgregarP = new Button("Agregar pedido");
        AgregarP.getStyleClass().add("buttons");
        AgregarP.setOnAction((ActionEvent event) ->{
            try {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_AgregarPedido.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                Pag_AgregarPedidoController controller = loader.getController();
                controller.setElementos(url_Imagen, producto, stage);
                stage.show();
                
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }
        });
         Button Eliminar = new Button("Eliminar ");
        Eliminar.getStyleClass().add("buttons");
        Eliminar.setOnAction(event ->{
            JOptionPane.showMessageDialog(null, "pedido eliminado");
        });
        
        Button Editar = new Button("Editar");
        Editar.getStyleClass().add("buttons");
         Editar.setOnAction(event ->{
           
             String Estado = Editar.getText();
            if(Estado.equalsIgnoreCase("editar")){
                Lcategoria2.setText("");
                Lprecio2.setText("");
                LCantidad2.setText("");
                Lcategoria2.requestFocus();
                Editar.setText("Guardar");
            }else if(Estado.equalsIgnoreCase("guardar")){
                // agregar logica para actualizar los datos
                JOptionPane.showMessageDialog(null, "datos actualizados");
                Editar.setText("Editar");
            }
        });
        
        // agrego los botones al layaoutbtn
        layoutbtn.getChildren().addAll(AgregarP,Eliminar,Editar);
         
        newVBox.getChildren().addAll(Lnombre,imagen,layout,layoutbtn);
        // agregamos el nuevo elemento al flowpane
        flowPane.getChildren().add(newVBox);
    }
    
    
    private void Dimensiones_EstiloTextfield(TextField text){
        
         //dimensiones del label
        text.setPrefSize(85, 17);
        // estilo
        text.getStyleClass().add("inputs");
        
    }
    
     private void Dimensiones_EstiloLabels(Label label){
        
         //dimensiones del label
        label.setPrefSize(113, 17);
        // estilo
        label.getStyleClass().add("Labels");
        
    }
}
