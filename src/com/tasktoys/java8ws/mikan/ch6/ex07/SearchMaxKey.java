/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex07;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mikan on 2015/09/16.
 *
 * @author mikan
 */
public class SearchMaxKey {

    private SearchMaxKey() {
        // static use only
    }

    public static String findMaxKey(ConcurrentHashMap<String, Long> source) {
        Objects.requireNonNull(source);
        return source.reduceEntries(1, (s1, s2) -> s1.getValue() > s2.getValue() ? s1 : s2).getKey();
    }
}
