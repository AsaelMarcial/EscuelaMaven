package com.escuela.escuelamaven;

import db.ColegioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pojos.ColegioPOJO;

/**
 * FXML Controller class
 *
 * @author dltun
 */
public class ColegioListaController implements Initializable {

    @FXML
    private ListView<ColegioPOJO> listvColegio;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfColegio;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvColegio.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaColegios();
    }


    private void actualizarListaColegios() {
        ColegioDAO colegioDAO = new ColegioDAO();
        this.listvColegio.setItems(colegioDAO.ObtenerColegios());
    }

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ColegioFormularioFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar colegio");
        stage.showAndWait();

        actualizarListaColegios();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        ColegioPOJO colegio = new ColegioPOJO();
        if (listvColegio.getSelectionModel().getSelectedItem() != null) {
            colegio = listvColegio.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ColegioFormularioFXML.fxml"));
            Parent root = loader.load();
            ColegioFormularioController controlador = loader.getController();

            controlador.recibirColegioActualización(colegio);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar colegio");
            stage.showAndWait();

            actualizarListaColegios();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un colegio de la lista");
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if (listvColegio.getSelectionModel().getSelectedItem() != null) {
            ColegioPOJO colegio = new ColegioPOJO();
            colegio = listvColegio.getSelectionModel().getSelectedItem();

            ColegioDAO colegioDAO = new ColegioDAO();
            colegioDAO.EliminarColegio(colegio.getIdColegio());

            actualizarListaColegios();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un colegio de la lista");
        }
    }

    @FXML
    private void btnRegresar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipalFXML.fxml"));
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
    private void btnProbarConexion_Click(ActionEvent event) {
    }

    @FXML
    private void btnBuscar_Click(ActionEvent event) {
        String buscar = txfColegio.getText();
        if(buscar.length() != 0){
            ColegioDAO colegioDAO = new ColegioDAO();
            this.listvColegio.setItems(colegioDAO.ObtenerColegiosPorNombre(txfColegio.getText()));
        }else{
            actualizarListaColegios();
        }
    }

    @FXML
    private void txfColegios_Changed(InputMethodEvent event) {
        actualizarListaColegios();
    }

}
