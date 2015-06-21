package com.tasktoys.java8ws.intptr_t.ch4.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ch4Ex04 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle circle = new Circle(100);
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		circle.centerXProperty().bind(
			Bindings.divide(scene.widthProperty(), 2));
		circle.centerYProperty().bind(
			Bindings.divide(scene.heightProperty(), 2));		
		
		// 円を画面内におさめるため、
		// 幅、高さいずれか小さい方の半分のサイズに合わせる
		circle.radiusProperty().bind(
			Bindings.divide(
				Bindings.min(scene.widthProperty(), scene.heightProperty()), 2)
		);
		
		pane.getChildren().add(circle);
		stage.setScene(scene);
		stage.show();
	}	
}
