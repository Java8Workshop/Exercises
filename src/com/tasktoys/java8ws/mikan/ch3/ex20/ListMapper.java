/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex20;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class ListMapper {

    private ListMapper() {
        // static use only
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(mapper);
        return list.stream().map(mapper::apply).collect(Collectors.toList());
    }
}
