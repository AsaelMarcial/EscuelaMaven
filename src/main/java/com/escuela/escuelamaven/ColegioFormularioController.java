package com.escuela.escuelamaven;

import db.ColegioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pojos.ColegioPOJO;

/**
 * FXML Controller class
 *
 * @author dltun
 */
public class ColegioFormularioController implements Initializable {

    @FXML
    private TextField txfNombre;
    @FXML
    private TextField txfTipo;
    @FXML
    private TextField txfCiudad;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;

    public boolean esNuevoRegistro = true;
    ColegioPOJO colegioExistente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colegioExistente = new ColegioPOJO();
    }

    public void recibirColegioActualización(ColegioPOJO colegio) {
        esNuevoRegistro = false;
        colegioExistente = colegio;
        this.txfNombre.setText(colegio.getNombre());
        this.txfTipo.setText(colegio.getTipo());
        this.txfCiudad.setText(colegio.getCiudad());
    }

    @FXML
    private void btnGuardar_Click(ActionEvent event) throws Throwable {
        String nombre = this.txfNombre.getText();
        String tipo = this.txfTipo.getText();
        String ciudad = this.txfCiudad.getText();

        if(nombre.isEmpty() || tipo.isEmpty() || ciudad.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Verifique no haya campos vacios");
        }else{
            ColegioDAO colegioDAO= new ColegioDAO();
            if(esNuevoRegistro){
                colegioDAO.RegistrarColegio(nombre, tipo, ciudad);
                JOptionPane.showMessageDialog(null, "Guardado correctamente");

                Stage stage = (Stage) btnGuardar.getScene().getWindow();
                stage.close();

            }else{
                colegioDAO.ActualizarColegio(colegioExistente.getIdColegio(), nombre, tipo, ciudad);
                JOptionPane.showMessageDialog(null, "Guardado correctamente");

                Stage stage = (Stage) btnGuardar.getScene().getWindow();
                stage.close();

            }

        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

}
