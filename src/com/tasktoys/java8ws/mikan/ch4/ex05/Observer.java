/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch4.ex05;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author mikan
 */
public class Observer {

    public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
        Set<ChangeListener<? super R>> changeListeners = new HashSet<>();
        Set<InvalidationListener> invalidationListeners = new HashSet<>();
        ObservableValue<R> value = new ObservableValue<R>() {
            @Override
            public R getValue() {
                return f.apply(t.getValue());
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
            public void addListener(InvalidationListener listener) {
                invalidationListeners.add(listener);
            }

            @Override
            public void removeListener(InvalidationListener listener) {
                invalidationListeners.remove(listener);
            }
        };
        t.addListener((observable, oldValue, newValue) -> {
            changeListeners.forEach(l -> l.changed(value, f.apply(oldValue), f.apply(newValue)));
        });
        t.addListener(observable -> invalidationListeners.forEach(l -> l.invalidated(observable)));
        return value;
    }

    public static <T, U, R> ObservableValue<R> observe(
            BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
        Set<ChangeListener<? super R>> changeListeners = new HashSet<>();
        Set<InvalidationListener> invalidationListeners = new HashSet<>();
        ObservableValue<R> value = new ObservableValue<R>() {
            @Override
            public R getValue() {
                return f.apply(t.getValue(), u.getValue());
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
            public void addListener(InvalidationListener listener) {
                invalidationListeners.add(listener);
            }

            @Override
            public void removeListener(InvalidationListener listener) {
                invalidationListeners.remove(listener);
            }
        };
        t.addListener((observable, oldValue, newValue) -> {
            changeListeners.forEach(l -> l.changed(
                    value, f.apply(oldValue, u.getValue()), f.apply(newValue, u.getValue())));
        });
        u.addListener((observable, oldValue, newValue) -> {
            changeListeners.forEach(l -> l.changed(
                    value, f.apply(t.getValue(), oldValue), f.apply(t.getValue(), newValue)));
        });
        t.addListener(observable -> invalidationListeners.forEach(l -> l.invalidated(observable)));
        u.addListener(observable -> invalidationListeners.forEach(l -> l.invalidated(observable)));
        return value;
    }
}
