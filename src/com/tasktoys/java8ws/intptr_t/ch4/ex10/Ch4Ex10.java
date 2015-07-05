package com.tasktoys.java8ws.intptr_t.ch4.ex10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Ch4Ex10 extends Application {
	final TextField locationBar = new TextField("https://github.com/Java8Workshop");
	final Button backButton = new Button("[戻]");

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final BorderPane pane = new BorderPane();		
		final AnchorPane topAnchorPane = new AnchorPane();
		
		final WebView browser = new WebView();
		final WebEngine engine = browser.getEngine();

		AnchorPane.setLeftAnchor(this.backButton, 0.0);
		AnchorPane.setLeftAnchor(this.locationBar, 42.);
		AnchorPane.setRightAnchor(this.locationBar, 0.);
		topAnchorPane.getChildren().addAll(this.backButton, this.locationBar);

		pane.setTop(topAnchorPane);
		pane.setCenter(browser);
		
		engine.load(locationBar.getText());
		
		// 戻るボタン押下時処理
		this.backButton.setOnAction(e -> {
			WebHistory history = engine.getHistory();
			int historyIndex = history.getCurrentIndex();
			ObservableList<WebHistory.Entry> entries = history.getEntries();
			
			if(historyIndex > 0 && historyIndex < entries.size()) {
				history.go(-1);
				locationBar.setText(entries.get(historyIndex - 1).getUrl());
			}
		});
		
		// TextField Enter
		this.locationBar.setOnAction(e -> {
			engine.load(locationBar.getText());
		});
		
		// ページ遷移処理
		engine.getLoadWorker().stateProperty().addListener((o, oldValue, newValue)->{
			if(newValue == State.SUCCEEDED) {
				locationBar.setText(engine.getLocation());
			}
		});

		primaryStage.setScene(new Scene(pane));
		primaryStage.show();		
	}

}
