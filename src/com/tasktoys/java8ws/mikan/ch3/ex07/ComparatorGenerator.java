/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch3.ex07;

import java.util.Comparator;

/**
 * @author mikan
 */
public class ComparatorGenerator {

    private ComparatorGenerator() {
        // static use only
    }

    public static Comparator<String> generate(boolean naturalOrder, boolean caseSensitive, boolean acceptSpace) {
        return (o1, o2) -> {
            String s1 = acceptSpace ? o1 : o1.replaceAll(" ", "");
            String s2 = acceptSpace ? o2 : o2.replaceAll(" ", "");
            int result = caseSensitive ? s1.compareTo(s2) : s1.compareToIgnoreCase(s2);
            return naturalOrder ? result : -result;
        };
    }
}
