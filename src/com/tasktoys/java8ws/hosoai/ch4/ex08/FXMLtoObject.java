package com.tasktoys.java8ws.hosoai.ch4.ex08;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class FXMLtoObject implements Initializable{
	@FXML ParentClass myobj;

	public void load() {
		try {
			FXMLLoader.load(getClass().getResource("myobj.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FXMLtoObject().load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(myobj.getName());
		myobj.getChildren().stream().map(c->"  "+c.getName()).forEach(System.out::println);		
	}
}

