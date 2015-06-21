package com.tasktoys.java8ws.hosoai.ch4.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFx extends Application{
	private String text = "Hello, JavaFX!!";
	public void start(Stage stage){
		GridPane pane = new GridPane();
		Label message = new Label(text);
		message.setFont(new Font(100));
		TextField field = new TextField(text);
		message.textProperty().bind(field.textProperty());

		pane.add(message, 0, 0);
		pane.add(field, 0, 1);
		stage.setScene(new Scene(pane));
		stage.setTitle("Hello");
		stage.show();
	}
	public static void main(String[] args) {
		HelloJavaFx.launch();
	}
}
