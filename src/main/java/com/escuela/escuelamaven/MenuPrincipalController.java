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
    public Button btnColegios;

    public void btnTutores_Click(ActionEvent actionEvent) throws IOException  {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TutorListaView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Lista de tutores");
        Stage stageActual = (Stage) btnAdministrarEstudiantes.getScene().getWindow();
        stageActual.close();
        stage.show();
    }


    public void btnAdministrarEstudiantes_Click(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EstudianteListaView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Lista de estudiantes");
        Stage stageActual = (Stage) btnAdministrarEstudiantes.getScene().getWindow();
        stageActual.close();
        stage.show();
    }

    public void btnOrigenes_Click(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("OrigenListaView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Origenes");
        Stage stageActual = (Stage) btnOrigenes.getScene().getWindow();
        stageActual.close();
        stage.show();
    }

    public void btnColegios_Click(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ColegiosListaView.fxml"));
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registrar Colegio");
        Stage stageActual = (Stage) btnColegios.getScene().getWindow();
        stageActual.close();
        stage.show();
    }

    public void btnSalud_Click(ActionEvent actionEvent) {
    }
}