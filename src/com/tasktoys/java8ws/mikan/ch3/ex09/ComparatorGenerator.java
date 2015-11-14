/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch3.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * @author mikan
 */
public class ComparatorGenerator {

    private ComparatorGenerator() {
        // static use only
    }

    public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (first, second) -> {
            for (String fieldName : fieldNames) {
                Comparable<?> firstValue = null;
                Comparable<?> secondValue = null;
                try {
                    Field firstField = first.getClass().getField(fieldName);
                    firstField.setAccessible(true);
                    firstValue = (Comparable) firstField.get(first);
                    Field secondField = second.getClass().getField(fieldName);
                    secondField.setAccessible(true);
                    secondValue = (Comparable) secondField.get(second);
                } catch (ReflectiveOperationException e) {
                    System.err.println("ERROR: " + e);
                    continue;
                }
                if (firstValue != null && secondValue != null) {
                    @SuppressWarnings("unchecked") // escape <?>
                    int compare = ((Comparable) firstValue).compareTo(secondValue);
                    System.out.println("Comparing " + firstValue + " : " + secondValue + " -> " + compare);
                    if (compare != 0) {
                        return compare;
                    }
                }
            }
            return 0; // perfect match (or nulls and/or errors contained).
        };
    }
}
