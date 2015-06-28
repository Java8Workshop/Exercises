package com.tasktoys.java8ws.intptr_t.ch4.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ch4Ex06 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		
		// top
		// AnchorPaneを利用して、ステージサイズに合わせてリサイズされる
		final Button topButton = new Button("Top");
		final AnchorPane topAnchorPane = new AnchorPane();
		AnchorPane.setLeftAnchor(topButton, 0.0);
		AnchorPane.setRightAnchor(topButton, 0.0);
		AnchorPane.setBottomAnchor(topButton, 0.0);
		topAnchorPane.getChildren().add(topButton);
				
		// bottom
		// ボタンのサイズは変わらず、真ん中に配置される
		final Button bottomButton = new Button("Bottom");
		BorderPane.setAlignment(bottomButton, Pos.CENTER);

		pane.setTop(topAnchorPane);
		pane.setLeft(new Button("Left"));
		pane.setCenter(new Button("Center"));
		pane.setRight(new Button("Right"));
		pane.setBottom(bottomButton);
		
		pane.setStyle("-fx-border-color: red");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
