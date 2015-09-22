/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex09;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author mikan
 */
public class ReduceArrayLists<T> {

    private final Stream<ArrayList<T>> source;

    public ReduceArrayLists(Stream<ArrayList<T>> source) {
        Objects.requireNonNull(source);
        this.source = source;
    }

    public ArrayList<T> toArrayList1() {
        return source.reduce((x, y) -> {
            ArrayList<T> result = new ArrayList<>(x.size() + y.size());
            result.addAll(x);
            result.addAll(y);
            return result;
        }).orElse(new ArrayList<>());
    }

    public ArrayList<T> toArrayList2() {
        return source.reduce(new ArrayList<>(), (x, y) -> {
            ArrayList<T> result = new ArrayList<>(x.size() + y.size());
            result.addAll(x);
            result.addAll(y);
            return result;
        });
    }

    public ArrayList<T> toArrayList3() {
        return source.reduce(new ArrayList<>(),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                },
                (x, y) -> {
                    ArrayList<T> result = new ArrayList<>(x.size() + y.size());
                    result.addAll(x);
                    result.addAll(y);
                    return result;
                });
    }
}
