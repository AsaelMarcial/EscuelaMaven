package com.escuela.escuelamaven;

import db.ColegioDAO;
import db.EstudianteDAO;
import db.OrigenDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojos.ColegioPOJO;
import pojos.EstudiantePOJO;
import pojos.OrigenPOJO;

public class EstudianteFormularioController implements Initializable {

    @FXML
    private TextField txfPrimerNombre;
    @FXML
    private TextField txfApellidoMaterno;
    @FXML
    private TextField txfSegundoNombre;
    @FXML
    private TextField txfApellidoPaterno;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;

    public boolean esNuevoRegistro = true;
    EstudiantePOJO estudianteExistente;

    @FXML
    private TextField txfHistorial;
    @FXML
    private CheckBox chkbEstaActivo;
    @FXML
    private ComboBox<OrigenPOJO> cmbOrigen;
    @FXML
    private ComboBox<ColegioPOJO> cmbColegio;

    ObservableList<OrigenPOJO> origenes;
    ObservableList<ColegioPOJO> colegios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        origenes = FXCollections.observableArrayList();
        colegios = FXCollections.observableArrayList();

        estudianteExistente = new EstudiantePOJO();
        cargarCmbOrigen();
        cargarCmbColegio();

    }

    public void cargarCmbOrigen(){
        OrigenDAO origenDAO = new OrigenDAO();
        origenes = origenDAO.ObtenerOrigenes();
        cmbOrigen.setItems(origenes);

    }

    public void cargarCmbColegio(){
        ColegioDAO colegioDAO = new ColegioDAO();
        colegios = colegioDAO.ObtenerColegios();
        cmbColegio.setItems(colegios);
    }

    public void recibirEstudianteActualización(EstudiantePOJO estudiante){
        esNuevoRegistro = false;
        estudianteExistente = estudiante;
        this.txfPrimerNombre.setText(estudiante.getPrimer_nom());
        this.txfSegundoNombre.setText(estudiante.getSeg_nom());
        this.txfApellidoPaterno.setText(estudiante.getPrimer_ape());
        this.txfApellidoMaterno.setText(estudiante.getSegundo_ape());
        this.txfHistorial.setText(estudiante.getHistorial());

        if(estudiante.isActivo()){
            this.chkbEstaActivo.setSelected(true);
        }else{
            this.chkbEstaActivo.setSelected(false);
        }

        this.cmbColegio.valueProperty().setValue(mostrarSeleccionadoCmbColegio(estudianteExistente.getIdColegio()));
        this.cmbOrigen.valueProperty().setValue(mostrarSeleccionadoCmbOrigen(estudianteExistente.getIdOrigen()));
    }

    public ColegioPOJO mostrarSeleccionadoCmbColegio(int idColegio){
        ColegioPOJO colegio = new ColegioPOJO();
        int index = 0;
        boolean bucle = true;
        while(bucle){
            colegio = colegios.get(index);

            if(idColegio == colegio.getIdColegio())
                return colegio;

            index++;
        }
        return colegio;
    }

    public OrigenPOJO mostrarSeleccionadoCmbOrigen(int idOrigen){
        OrigenPOJO origen = new OrigenPOJO();
        int index = 0;
        boolean bucle = true;
        while(bucle){
            origen = origenes.get(index);

            if(idOrigen == origen.getIdOrigen())
                return origen;

            index++;
        }
        return origen;
    }


    @FXML
    private void btnGuardar_Click(ActionEvent event) {
        String primer_nom = this.txfPrimerNombre.getText();
        String seg_nom = this.txfSegundoNombre.getText();
        String primer_ape = this.txfApellidoPaterno.getText();
        String seg_ape = this.txfApellidoMaterno.getText();
        boolean activo = this.chkbEstaActivo.isSelected();

        ColegioPOJO colegio = new ColegioPOJO();
        colegio = this.cmbColegio.getSelectionModel().getSelectedItem();

        String historial = this.txfHistorial.getText();

        OrigenPOJO origen = new OrigenPOJO();
        origen = this.cmbOrigen.getSelectionModel().getSelectedItem();

        if(primer_nom.isEmpty() || primer_ape.isEmpty() || colegio == null || origen == null || historial.isEmpty()){
            System.out.println("Verifique que no haya campos vacíos");
        }else{
            EstudianteDAO estudianteDAO= new EstudianteDAO();
            if(esNuevoRegistro){
                estudianteDAO.RegistrarEstudiante(primer_nom, primer_ape, seg_nom, seg_ape, activo, colegio.getIdColegio(), historial, origen.getIdOrigen() );
            }else{
                estudianteDAO.ActualizarEstudiante(estudianteExistente.getIdEstudiante(), primer_nom, primer_ape, seg_nom, seg_ape, activo, colegio.getIdColegio(), historial, origen.getIdOrigen());
            }
            Stage stage = (Stage) btnGuardar.getScene().getWindow();
            System.out.println("Modulo de registro concluido");
            stage.close();
        }
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
