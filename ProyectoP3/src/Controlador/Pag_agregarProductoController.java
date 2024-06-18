/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.FabricaEntidad_sistema;
import modelo.FabricaEntidad_sistema2;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_agregarProductoController implements Initializable {
    
    
    // inicializo el FileCooser herramienta de javafx que ayuda a seleccionar archivos del sistema
    FileChooser fileC = new FileChooser();
    Stage stage1;

    public void setStage(Stage stage) {
        this.stage1 = stage;
    }
    // varaible global para ayudar a nombrar las imagenes
    int i = obtenerIterador();
    
   
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
    private TextField textCantidadunidades;

    @FXML
    private TextField textnombre;
    
     @FXML
    private ImageView imagen_P;

    @FXML
    private Label info_Producto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboCategoria.getItems().addAll("Sombrero","Bolso","Otros accesorios");
        info_Producto.setVisible(false);
        
        // le agrego un titulo al filechooser
        fileC.setTitle("Selecciona una imagen");
        // le agrego un filtro para que solo se puedan subir archivos .png,.jpg,.jpeg
        fileC.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        // le agrego un directorio incial utilizo System.getProperty("user.home"),"/Downloads" 
        // para abrir el directorio de descargas desde cualquier pc
          fileC.setInitialDirectory(new File(System.getProperty("user.home"),"/Downloads"));
    }
    
    
    @FXML
    void event_guardar(ActionEvent event) {
        
        FabricaEntidad_sistema fabrica = new FabricaEntidad_sistema2();
        try{
            fabrica.RegistroProducto(
                textnombre.getText(), 
                "producto", 
                textDescripcion.getText(), 
                textColeccion.getText(), 
                comboCategoria.getValue(), 
                Integer.parseInt(textPrecio.getText()),
                Integer.parseInt(textCantidadunidades.getText()));
        }catch(NumberFormatException e){
            
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("SUGERENCIA");
        alerta.setContentText("Por favor revise que ningun campo este vacio");
        alerta.show();
    
        }
        
        // limpiamos los campos
        textnombre.setText("");
        textDescripcion.setText("");
        textColeccion.setText("");
        comboCategoria.setValue(null);
        textPrecio.setText("");
        textCantidadunidades.setText("");
        textnombre.requestFocus();
        imagen_P.setImage(null);
        
        
    }
    
    @FXML
    void event_agregarInfoP(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Pag_agregar_P.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Pag_agregar_proveedorController Controller = loader.getController();
            Controller.setStage(stage);
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {

            System.out.println("Error en el cambio de ventana");
        }
    }

    @FXML
    void event_agregarfoto(ActionEvent event) {
        
        // hacemos visible el LabelInfo
        info_Producto.setVisible(true);
         // abrimos una ventana para que el usuario seleccione la imagen
        File file = fileC.showOpenDialog(new Stage());
        // verificamos si el usuario subio la imagen
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imagen_P.setImage(image);
        }
        
        /* Definir la carpeta de destino dentro del proyecto
        //System.getProperty("user.dir") nos devulve la ruta de la carpeta del proyceto
        para luego agregar la ruta especefica dentro del proyecto donde queremos guardar la imagen
        */ 
            File destinationDir = new File(System.getProperty("user.dir"), "src/imagenes_productos");
            // si no existe lo crea con el metodo mkdirs()
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }
             
            // creo el archivo de destino con el nombre del producto.
            File destinationFile = new File(destinationDir, "imagen"+i+".jpg");
            i++;
            //guardamos el iterador que nombra las imagenes
            guardar_iterador();
        try {
            copyFile(file, destinationFile);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        } 

    }
    
    // este metodo copia la imagen de la carpeta donde esta hacia la carpeta de imagen_productos
     private void copyFile(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
     
    private void guardar_iterador() {

        try {
            FileWriter escritura = new FileWriter("src/Controlador/iterador_nombre_imagenes/iterador.txt");
            escritura.write(String.valueOf(i));
            escritura.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
    
    private int obtenerIterador() {

        int iterador = 1;

        try {

            Scanner scanner = new Scanner(new File("src/Controlador/iterador_nombre_imagenes/iterador.txt"));

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.equalsIgnoreCase(" ")) {
                    iterador = Integer.parseInt(linea);
                } else {
                    iterador = 1;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return iterador;
    }  
}
