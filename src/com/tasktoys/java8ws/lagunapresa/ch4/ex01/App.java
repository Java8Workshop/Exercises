package com.tasktoys.java8ws.lagunapresa.ch4.ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));

        int wWidth = 600;
        int wHeight = 200;
        Scene scene = new Scene(root, wWidth, wHeight);
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        stage.setTitle("title");
        stage.setScene(scene);

        stage.show();
    }
}
