package com.tasktoys.java8ws.mrbearing.ch4.ex5;

import static javafx.beans.binding.Bindings.greaterThanOrEqual;
import static javafx.beans.binding.Bindings.lessThanOrEqual;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex5 extends Application {

	public static <T, R> ObservableValue<R> observe(Function<T, R> f,
			ObservableValue<T> t) {
		return new ObservableValue<R>() {

			@Override
			public void addListener(InvalidationListener arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void removeListener(InvalidationListener arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void addListener(ChangeListener<? super R> arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public R getValue() {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}

			@Override
			public void removeListener(ChangeListener<? super R> arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}
		};

	}

	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f,
			ObservableValue<T> t, ObservableValue<U> u) {
		return null;

	}

	@Override
	public void start(Stage stage) throws Exception {
		Button smaller = new Button("Smaller");
	      Button larger = new Button("Larger");
	      Rectangle gauge = new Rectangle(0, 5, 50, 15);
	      Rectangle outline = new Rectangle(0, 5, 100, 15);
	      outline.setFill(null);
	      outline.setStroke(Color.BLACK);
	      Pane pane = new Pane();
	      pane.getChildren().addAll(gauge, outline);
	      smaller.setOnAction(event -> gauge.setWidth(gauge.getWidth() - 10));
	      larger.setOnAction(event -> gauge.setWidth(gauge.getWidth() + 10));
/*
	      larger.disableProperty().bind(
	    		  observe(t -> t >= 100 ,
	    		  	gauge.widthProperty()));
*/
	      /*
	      smaller.disableProperty().bind(lessThanOrEqual(gauge.widthProperty(), 0));
	      larger.disableProperty().bind(greaterThanOrEqual(gauge.widthProperty(), 100));
	       */

	      HBox box = new HBox(10);
	      box.getChildren().addAll(smaller, pane, larger);
	      Scene scene = new Scene(box);
	      stage.setScene(scene);
	      stage.show();
		stage.show();

	}

}
