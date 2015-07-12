package com.tasktoys.java8ws.hosoai.ch4.ex05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class ObservableValueFactory {
	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t){
		return new ObservableValue<R>(){
			List<InvalidationListener> invalidationListeners = new ArrayList<>();
			List<ChangeListener<? super R>> changeListeners = new ArrayList<>();
			@Override
			public void addListener(InvalidationListener arg0) {
				invalidationListeners.add(arg0);
			}

			@Override
			public void removeListener(InvalidationListener arg0) {
				invalidationListeners.remove(arg0);
			}

			@Override
			public void addListener(ChangeListener<? super R> listener) {
				changeListeners.add(listener);
			}
			@Override
			public void removeListener(ChangeListener<? super R> listener) {
				changeListeners.remove(listener);
			}
			
			@Override
			public R getValue() {
				t.addListener(new ChangeListener<T>() {
					@Override
					public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
						for(ChangeListener l : changeListeners){
							l.changed(observable, oldValue, newValue);
						}
					}
				});
				t.addListener(new InvalidationListener() {
					@Override
					public void invalidated(Observable observable) {
						for(InvalidationListener l : invalidationListeners){
							l.invalidated(observable);
						}
					}
				});
				return f.apply(t.getValue());
			}
		};
	}
	
	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u){
		return null;
	}
	
	
	public static void main(String[] args) {
		Button larger = new Button();
		Rectangle gauge = new Rectangle();
		larger.disableProperty().bind(observe(t-> t.doubleValue() >= 100, gauge.widthProperty()));
	}
}
