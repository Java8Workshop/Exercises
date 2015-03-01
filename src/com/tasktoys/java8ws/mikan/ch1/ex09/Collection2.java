/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author mikan
 */
public interface Collection2<E> extends Collection<E> {

    default void forEachIf(Consumer<E> action, Predicate<E> filter) {
        this.stream().filter(filter).forEach(action);
    }
}
