package com.escuela.escuelamaven;

        import db.TutorDAO;
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
        import pojos.TutorPOJO;

/**
 * FXML Controller class
 *
 * @author israz
 */
public class TutorListaController implements Initializable {

    @FXML
    private ListView<TutorPOJO> listvTutores;
    @FXML
    private Label lblPruebaSQL;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txfBuscarTutor;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listvTutores.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        actualizarListaTutores();
    }

    private void actualizarListaTutores(){
        TutorDAO tutorDAO = new TutorDAO();
        listvTutores.setItems(tutorDAO.ObtenerTutores());
    }

    @FXML
    private void listvEstudiantes_OnDragEntered(DragEvent event) {
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TutorFormularioView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar tutor");
        stage.showAndWait();

        actualizarListaTutores();
    }

    @FXML
    private void btnActualizar_Click(ActionEvent event) throws IOException {
        TutorPOJO tutor = new TutorPOJO();
        if (listvTutores.getSelectionModel().getSelectedItem() != null) {
            tutor = listvTutores.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TutorFormularioView.fxml"));
            Parent root = loader.load();
            TutorFormularioController controlador = loader.getController();

            controlador.recibirTutor(tutor);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar tutor");
            stage.showAndWait();

            actualizarListaTutores();
        } else {
            System.out.println("Debes selccionar un tutor de la lista");
        }
    }

    @FXML
    private void btnEliminar_Click(ActionEvent event) {
        if (listvTutores.getSelectionModel().getSelectedItem() != null) {
            TutorPOJO tutor = new TutorPOJO();
            tutor = listvTutores.getSelectionModel().getSelectedItem();

            TutorDAO tutorDAO = new TutorDAO();
            tutorDAO.EliminarTutor(tutor.getIdAcudiente());

            actualizarListaTutores();
        } else {
            System.out.println("Debes selccionar un estudiante de la lista");
        }
    }

    @FXML
    private void txfBuscarEstudiante_TextChanged(InputMethodEvent event) {
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
