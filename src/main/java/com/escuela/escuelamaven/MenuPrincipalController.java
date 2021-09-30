package com.escuela.escuelamaven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {
    public Button btnAdministrarEstudiantes;
    public Button btnHistoriasAcademicas;
    public Button btnOrigenes;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void btnTutores_Click(ActionEvent actionEvent) {
    }

    public void btnHistoriasAcademicas_Click(ActionEvent actionEvent) {
    }

    public void btnAdministrarEstudiantes_Click(ActionEvent actionEvent) {

    }

    public void btnOrigenes_Click(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OrigenesListaFXML.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Origenes");
        Stage stageActual = (Stage) btnOrigenes.getScene().getWindow();
        stageActual.close();
        stage.show();
    }
}