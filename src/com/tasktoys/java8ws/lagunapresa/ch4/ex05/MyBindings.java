package com.tasktoys.java8ws.lagunapresa.ch4.ex05;

import javafx.beans.value.ObservableValue;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import static javafx.beans.binding.Bindings.createObjectBinding;

public class MyBindings {

    public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
        Objects.requireNonNull(f);
        Objects.requireNonNull(t);
        return createObjectBinding(() -> f.apply(t.getValue()), t);
    }

    public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
        Objects.requireNonNull(f);
        Objects.requireNonNull(t);
        Objects.requireNonNull(u);
        return createObjectBinding(() -> f.apply(t.getValue(), u.getValue()), t, u);
    }

    private MyBindings() {
    }

}
