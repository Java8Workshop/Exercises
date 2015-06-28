package com.tasktoys.java8ws.intptr_t.ch4.ex07;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ch4Ex07 extends Application{
	final Label usernameLabel = new Label("user name:");
	final TextField username = new TextField();
	final Label passwordLabel = new Label("password:");
	final PasswordField password = new PasswordField();
	final Button okButton = new Button("Ok");
	final Button cancelButton = new Button("Cancel");
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final GridPane pane = new GridPane();
		final double rem = new Text("").getLayoutBounds().getHeight();
		final HBox buttons = new HBox(10);
		buttons.getChildren().addAll(this.okButton, this.cancelButton);
		
		pane.add(this.usernameLabel, 0, 0);
		pane.add(this.username, 1, 0);
		pane.add(this.passwordLabel, 0, 1);
		pane.add(this.password, 1, 1);
		pane.add(buttons, 0, 2, 2, 1);
		
		buttons.setAlignment(Pos.CENTER);
		
		GridPane.setHalignment(usernameLabel, HPos.RIGHT);
		GridPane.setHalignment(this.passwordLabel, HPos.RIGHT);
		
		pane.setHgap(0.8 * rem);
		pane.setVgap(0.8 * rem);
		pane.setPadding(new Insets(0.8 * rem));
		
		pane.setGridLinesVisible(true);

		// CSSを使わないでコントロール境界を設定する
		//  buttons.setStyle("-fx-border-color: red;");
		BorderStroke stroke = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
		Border border = new Border(stroke);
		buttons.setBorder(border);
		
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
