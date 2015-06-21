package com.tasktoys.java8ws.intptr_t.ch4.ex05;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ch4Ex05 extends Application {
	final Button smaller = new Button("Smaller");
	final Button larger = new Button("Larger");
	final Rectangle borderRect = new Rectangle();
	final Rectangle gauge = new Rectangle();
	final CheckBox overable = new CheckBox();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox(10);
		HBox hbox = new HBox(10);
		Pane pane = new Pane();
		this.overable.setText("超えてみせる!");
		this.overable.setSelected(true);
		
		//this.smaller.disableProperty().bind(
		//	Bindings.lessThanOrEqual(gauge.widthProperty(), 0));
		this.smaller.disableProperty().bind(observe(
			t -> t.doubleValue() <= 0., gauge.widthProperty()
		));
		
		//this.larger.disableProperty().bind(
		//	Bindings.greaterThanOrEqual(gauge.widthProperty(), 100));
		this.larger.disableProperty().bind(observe(
			(t, c) -> t.doubleValue() >= 100. && !c.booleanValue(), gauge.widthProperty(), overable.selectedProperty()));
		
		this.smaller.setOnAction(event -> {
			this.gauge.setWidth(this.gauge.getWidth() - 10.);
		});
		
		this.larger.setOnAction(event -> {
			this.gauge.setWidth(this.gauge.getWidth() + 10.);
		});
		this.overable.setOnAction(event -> {
			if(!this.overable.isSelected() && (this.gauge.getWidth() > 100.)) {
				this.gauge.setWidth(100.);
			}
		});

		// gauge
		this.gauge.setFill(Color.BLACK);
		this.gauge.setX(0);
		this.gauge.setY(0);
		this.gauge.setWidth(50);
		this.gauge.setHeight(20);
		this.borderRect.setFill(null);
		this.borderRect.setStroke(Color.GRAY);
		this.borderRect.setX(0);
		this.borderRect.setY(0);
		this.borderRect.setWidth(100);
		this.borderRect.setHeight(20);
		
		pane.getChildren().addAll(this.gauge, this.borderRect);
		
		hbox.setPadding(new Insets(5));
		hbox.getChildren().addAll(this.smaller, pane, this.larger);
		vbox.setPadding(new Insets(5));
		vbox.getChildren().addAll(this.overable, hbox);
		stage.setScene(new Scene(vbox));
		stage.show();
	}
	
	public static <T, R> ObservableValue<R> observe(
		Function<T, R> f, ObservableValue<T> t)
	{
		return new ObservableValue<R>() {
			private final Map<ChangeListener<? super R>,ChangeListener<T>> changeListeners = new HashMap<>();
			
			@Override
			public void addListener(InvalidationListener listener) {
				t.addListener(listener);
			}

			@Override
			public void removeListener(InvalidationListener listener) {
				t.removeListener(listener);
			}

			@Override
			public void addListener(ChangeListener<? super R> listener) {
				ChangeListener<T> tListener = (observer, oldValue, newValue) -> {
					listener.changed(this, f.apply(oldValue), f.apply(newValue));
				};
				t.addListener(tListener);
				this.changeListeners.put(listener, tListener);
			}

			@Override
			public R getValue() {
				return f.apply(t.getValue());
			}

			@Override
			public void removeListener(ChangeListener<? super R> listener) {
				ChangeListener<T> tListener = this.changeListeners.getOrDefault(listener, null);
				if(tListener != null) {
					t.removeListener(tListener);
					this.changeListeners.remove(listener);
				}
			}
		};
	}

	public static <T, U, R> ObservableValue<R> observe(
		BiFunction<T, U, R> f, ObservableValue<T> t,
		ObservableValue<U> u)
	{
		return new ObservableValue<R>() {
			private final Map<ChangeListener<? super R>, ChangeListener<T>> changeTListeners = new HashMap<>();
			private final Map<ChangeListener<? super R>, ChangeListener<U>> changeUListeners = new HashMap<>();
			
			@Override
			public void addListener(InvalidationListener listener) {
				t.addListener(listener);
				u.addListener(listener);
			}

			@Override
			public void removeListener(InvalidationListener listener) {
				t.removeListener(listener);
				u.removeListener(listener);
			}

			@Override
			public void addListener(ChangeListener<? super R> listener) {
				ChangeListener<T> tListener = (observer, oldValue, newValue) -> {
					listener.changed(this, f.apply(oldValue, u.getValue()), f.apply(newValue, u.getValue()));
				};
				ChangeListener<U> uListener = (observer, oldValue, newValue) -> {
					listener.changed(this, f.apply(t.getValue(), oldValue), f.apply(t.getValue(), newValue));
				};
				t.addListener(tListener);
				u.addListener(uListener);
				
				this.changeTListeners.put(listener, tListener);
				this.changeUListeners.put(listener, uListener);
			}

			@Override
			public R getValue() {				
				return f.apply(t.getValue(), u.getValue());
			}

			@Override
			public void removeListener(ChangeListener<? super R> listener) {
				ChangeListener<T> tListener = this.changeTListeners.getOrDefault(listener, null);
				if(tListener != null) {
					t.removeListener(tListener);					
					this.changeTListeners.remove(listener);
				}
				
				ChangeListener<U> uListener = this.changeUListeners.getOrDefault(listener, null);
				if(uListener != null) {
					u.removeListener(uListener);
					this.changeUListeners.remove(uListener);
				}
			}
		};
	}
}
