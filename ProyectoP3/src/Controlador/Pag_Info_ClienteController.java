/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import ConexionDAO.ClienteDAO;
import ConexionDAO.ConexionMySQL;
import ConexionDAO.DAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.FabricaEntidad;
import modelo.FabricaEntidad2;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class Pag_Info_ClienteController implements Initializable {
    
    FabricaEntidad fabrica;
    Cliente cliente;
    Button btnCliente;
    Stage stage;
    
    void setCliente(Cliente cliente, Stage stage, Button btncliente) {
       this.cliente = cliente;
       this.stage = stage;
       this.btnCliente = btncliente;
       cargarCliente();
    }
    
    @FXML
    private TextField InputDireccion;

    @FXML
    private TextField InputNombre;

    @FXML
    private ImageView imagen;

    @FXML
    private TextField inputCiudad;

    @FXML
    private TextField inputCorreo;

    @FXML
    private TextField inputMetodoPago;

    @FXML
    private TextField inputPais;

    @FXML
    private TextField inputTelefono;

    @FXML
    private TextField inputWhatsapp;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void cargarCliente(){
        
        InputNombre.setText(cliente.getNombre());
        InputDireccion.setText(cliente.getDireccion());
        inputWhatsapp.setText(cliente.getWhatsapp());
        inputCiudad.setText(cliente.getCiudad());
        inputPais.setText(cliente.getPais());
        inputCorreo.setText(cliente.getCorreo());
        inputMetodoPago.setText(cliente.getMetodoPago());
        inputTelefono.setText(cliente.getTelefono());
        InputNombre.requestFocus();
    }
    
      @FXML
    void event_UpdateCliente(ActionEvent event) {
        
        fabrica = new FabricaEntidad2();
        
        // seteamos los nuevos valores
        cliente.setNombre(InputNombre.getText());
        cliente.setDireccion(InputDireccion.getText());
        cliente.setWhatsapp(inputWhatsapp.getText());
        cliente.setCiudad(inputCiudad.getText());
        cliente.setPais(inputPais.getText());
        cliente.setCorreo(inputCorreo.getText());
        cliente.setMetodoPago(inputMetodoPago.getText());
        cliente.setTelefono(inputTelefono.getText());
        
        // actualizamod el cliente
        fabrica.UpdateCliente(cliente);
        btnCliente.setText(InputNombre.getText());
        stage.close();
    }
}
