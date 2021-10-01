package com.escuela.escuelamaven;

import static db.Conexion.ConectarBD;
import db.EstudianteDAO;
import db.InformeSaludDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojos.EstudiantePOJO;
import pojos.InformeSaludPOJO;

/**
 * Controller del FXML Formulario de Informe de salud, el cual tiene la capacidad de
 * registrar o actualizar un nuevo informe de salud
 *
 * 
 * @author asael
 * 
 */

public class InformeSaludFormularioController  implements Initializable {
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txfSeguroSocial;
    @FXML
    private TextField txfGrupoSang;
    @FXML
    private ComboBox<EstudiantePOJO> cmbInformes;

    EstudiantePOJO est;
    InformeSaludPOJO pojo;
    private boolean isUpdate;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        est = new EstudiantePOJO();
        pojo = new InformeSaludPOJO();
        cargarCombo();
    }

    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        est = cmbInformes.getValue();
        String seguro = txfSeguroSocial.getText();
        String sangre = txfGrupoSang.getText();

        if (seguro.isEmpty() || sangre.isEmpty()) {
            System.out.println("Verifique que no haya campos vacíos");
        } else {
            InformeSaludDAO infoDAO = new InformeSaludDAO();
            if (isUpdate == true) {
                InformeSaludDAO.ActualizarInforme(est.getIdEstudiante(), seguro, sangre);
                Stage stage = (Stage) btnGuardar.getScene().getWindow();
                stage.close();
            } else {
                infoDAO.RegistrarInformacionSalud(est.getIdEstudiante(), seguro, sangre);
                Stage stage = (Stage) btnGuardar.getScene().getWindow();
                stage.close();
            }
        }
    }

    private void cargarCombo() {
        ObservableList<EstudiantePOJO> listaEstudiantes = FXCollections.observableArrayList();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        cmbInformes.setItems(estudianteDAO.ObtenerEstudiantes());
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    void setDatos(InformeSaludPOJO pojo) {

        cmbInformes.setValue(est);
        cmbInformes.setEditable(false);
        txfSeguroSocial.setText(pojo.getNum_seguro_social());
        txfGrupoSang.setText(pojo.getGrupo_sang());
        isUpdate = true;
    }
}
