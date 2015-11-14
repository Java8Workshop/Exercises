/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch3.ex23;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author mikan
 */
public class Pair<T> extends AbstractMap.SimpleEntry<T, T> {

    public Pair(T key, T value) {
        super(key, value);
    }

    public <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return new Pair<>(mapper.apply(getKey()), mapper.apply(getValue()));
    }
}
