package com.escuela.escuelamaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase Main del programa por el cual se ejecuta, al correr el programa esta
 * es la clase que inicializa.
 *
 * @author dltun, isra, asael, leslie
 * 
 */

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipalView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Menu principal");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}