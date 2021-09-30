package com.escuela.escuelamaven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuPrincipalController {
    public Button btnAdministrarEstudiantes;
    public Button btnHistoriasAcademicas;
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
}