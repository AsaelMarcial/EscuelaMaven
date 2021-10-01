package com.escuela.escuelamaven;


import db.Conexion;
import db.EstudianteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojos.EstudiantePOJO;

/**
 * Controller del FXML de la lista de Estudiante, el cual contiene las funcionalidades
 * CRUD de Estudiante, administrandolos mediante una lista.
 *
 * @author isra
 * 
 */

public class EstudianteListaController implements Initializable {

    @FXML
    private ListView<EstudiantePOJO> listvEstudiantes;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnRegresar;
    @FXML
    private TextField txfEstudiante;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvEstudiantes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaEstudiantes();
    }

    private void actualizarListaEstudiantes() {
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        this.listvEstudiantes.setItems(estudianteDAO.ObtenerEstudiantes());
    }

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {

    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EstudianteFormularioView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar estudiante");
        stage.showAndWait();

        actualizarListaEstudiantes();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        EstudiantePOJO estudiante;
        if (listvEstudiantes.getSelectionModel().getSelectedItem() != null) {
            estudiante = listvEstudiantes.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("EstudianteFormularioView.fxml"));
            Parent root = loader.load();
            EstudianteFormularioController controlador = loader.getController();

            controlador.recibirEstudianteActualización(estudiante);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar estudiante");
            stage.showAndWait();

            actualizarListaEstudiantes();
        } else {
            System.out.println("Debes selccionar un estudiante de la lista");
        }

    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if (listvEstudiantes.getSelectionModel().getSelectedItem() != null) {
            EstudiantePOJO estudiante = new EstudiantePOJO();
            estudiante = listvEstudiantes.getSelectionModel().getSelectedItem();

            EstudianteDAO estudianteDAO = new EstudianteDAO();
            estudianteDAO.EliminarEstudiante(estudiante.getIdEstudiante());

            actualizarListaEstudiantes();
        } else {
            System.out.println("Debes selccionar un estudiante de la lista");
        }
    }

    @FXML
    private void txfBuscarEstudiante_TextChanged(InputMethodEvent event) {
        //consulta
    }

    @FXML
    private void btnProbarConexion_Click(ActionEvent event) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = conexion.ConectarBD();
        if (conn != null) {
            System.out.println("Conexión establecida");
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

}
