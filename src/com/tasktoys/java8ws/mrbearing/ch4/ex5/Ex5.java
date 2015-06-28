package com.tasktoys.java8ws.mrbearing.ch4.ex5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex5 extends Application {

	public static <T, R> ObservableValue<R> observe(Function<T, R> f,
			ObservableValue<T> t) {

		return new ObservableValue<R>() {
			Map<ChangeListener<? super R>, ChangeListener<T>> changeListenerMap = new HashMap<>();
			@Override
			public R getValue() {
				return f.apply(t.getValue());
			}

			@Override
			public void addListener(InvalidationListener arg0) {
				t.addListener(arg0);
			}
			@Override
			public void removeListener(InvalidationListener arg0) {
				t.removeListener(arg0);
			}

			@Override
			public void addListener(ChangeListener<? super R> arg0) {
				ChangeListener<T> tlistener = (observer, oldVal, newVal) -> {
					arg0.changed(this, f.apply(oldVal), f.apply(newVal));
				};
				t.addListener(tlistener);
			}

			@Override
			public void removeListener(ChangeListener<? super R> arg0) {
				ChangeListener<T> tListener = this.changeListenerMap
						.getOrDefault(arg0, null);
				if (tListener != null) {
					t.removeListener(tListener);
					this.changeListenerMap.remove(arg0);
				}
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
		larger.disableProperty().bind(
				observe(t -> t.doubleValue() >= 100
					, gauge.widthProperty()));
		smaller.disableProperty().bind(
				observe(t->t.doubleValue()<=0. , gauge.widthProperty()));

		HBox box = new HBox(10);
		box.getChildren().addAll(smaller, pane, larger);
		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
		stage.show();

	}

	public static void main(String[] args) {
		Ex5.launch(args);
	}

}
