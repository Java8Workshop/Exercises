package com.tasktoys.java8ws.mrbearing.ch4.ex1;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex1FX extends Application{



	@Override
	public void start(Stage stage) throws Exception {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("_ex1.fxml"));
			TextField textField = (TextField) root.lookup("#txField");
			Label label =(Label) root.lookup("#label");


			//textField.textProperty().bind(label.textProperty());
			label.textProperty().bind(textField.textProperty());

			stage.setScene(new Scene(root));
			stage.show();
		}catch(IOException ioe){
			ioe.printStackTrace();
			Platform.exit();
			System.exit(0);
		}
	}




}
