/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex08;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author mikan
 */
public class ArraysSort {

    /**
     * Sort by sequential execution.
     *
     * @param words list of words
     */
    public void doSort(String[] words) {
        Objects.requireNonNull(words);
        Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
    }

    /**
     * Sort by parallel execution.
     *
     * @param words list of words
     */
    public void doSortAsParallel(String[] words) {
        Objects.requireNonNull(words);
        if (words.length <= (1 << 13)) { // Arrays.MIN_ARRAY_SORT_GRAN = 1 << 13 (2^13 = 8192)
            System.out.println("WARNING: words.length is not reaches a minimum granularity.");
        }
        Arrays.parallelSort(words, (first, second) -> Integer.compare(first.length(), second.length()));
    }
}
