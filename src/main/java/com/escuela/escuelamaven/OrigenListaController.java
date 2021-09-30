package com.escuela.escuelamaven;

import db.OrigenDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pojos.OrigenPOJO;


public class OrigenListaController implements Initializable{
    @FXML
    private ListView<OrigenPOJO> listvOrigenes;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfOrigen;
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnRegistrar;
    @FXML
    private Button btnBuscar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvOrigenes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaOrigenes();
    }

    private void actualizarListaOrigenes() {
        OrigenDAO origenDAO = new OrigenDAO();
        this.listvOrigenes.setItems(origenDAO.ObtenerOrigenes());
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OrigenFormularioView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar origen");
        stage.showAndWait();

        actualizarListaOrigenes();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        OrigenPOJO origenSeleccionado = new OrigenPOJO();
        if (listvOrigenes.getSelectionModel().getSelectedItem() != null) {
            origenSeleccionado = listvOrigenes.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrigenFormularioFXML.fxml"));
            Parent root = loader.load();
            OrigenFormularioController controlador = loader.getController();
            controlador.setDatos(origenSeleccionado);


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar origen");
            stage.showAndWait();

            actualizarListaOrigenes();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un origen de la lista");
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if (listvOrigenes.getSelectionModel().getSelectedItem() != null) {
            OrigenPOJO origen = new OrigenPOJO();
            origen = listvOrigenes.getSelectionModel().getSelectedItem();

            OrigenDAO origenDAO = new OrigenDAO();
            boolean tieneEstudiantes = origenDAO.TieneEstudiantes(origen.getIdOrigen());

            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminarlo?");

            if(confirmacion == 0 && !tieneEstudiantes){
                origenDAO.EliminarOrigen(origen.getIdOrigen());
            }else if(tieneEstudiantes){
                JOptionPane.showMessageDialog(null, "No se puede eliminar el origen por que tiene estudiantes asignados");
            }

            actualizarListaOrigenes();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un origen de la lista");
        }
    }


    @FXML
    private void btnRegresar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipalView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Menu principal");
        Stage stageActual = (Stage) btnRegresar.getScene().getWindow();
        stageActual.close();
        stage.show();
    }

    @FXML
    private void btnBuscar_Click(ActionEvent event) {
        String buscar = txfOrigen.getText();
        if(buscar.length() != 0){
            OrigenDAO origenDAO = new OrigenDAO();
            this.listvOrigenes.setItems(origenDAO.ObtenerOrigenesPorEstado(txfOrigen.getText()));
        }else{
            actualizarListaOrigenes();
        }
    }
}
