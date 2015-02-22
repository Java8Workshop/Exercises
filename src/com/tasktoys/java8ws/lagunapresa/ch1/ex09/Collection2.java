package com.tasktoys.java8ws.lagunapresa.ch1.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<? super T> action, Predicate<? super T> filter) {
        stream().filter(filter).forEach(action);
    }

    static class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
    }

}
