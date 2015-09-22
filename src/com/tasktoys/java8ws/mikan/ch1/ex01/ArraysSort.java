/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author mikan
 */
public class ArraysSort {

    /**
     * Sort by sequential execution.
     *
     * @param words list of words
     * @return thread ids
     */
    public List<Long> doSort(String[] words) {
        Objects.requireNonNull(words);
        List<Long> threadIds = new ArrayList<>();
        threadIds.add(Thread.currentThread().getId());
        Arrays.sort(words, (first, second) -> {
            threadIds.add(Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length());
        });
        return threadIds;
    }

    /**
     * Sort by parallel execution.
     *
     * @param words list of words
     * @return thread ids
     */
    public List<Long> doSortAsParallel(String[] words) {
        Objects.requireNonNull(words);
        if (words.length <= (1 << 13)) { // Arrays.MIN_ARRAY_SORT_GRAN = 1 << 13 (2^13 = 8192)
            System.out.println("WARNING: words.length is not reaches a minimum granularity.");
        }
        List<Long> threadIds = new CopyOnWriteArrayList<>();
        threadIds.add(Thread.currentThread().getId());
        Arrays.parallelSort(words, (first, second) -> {
            threadIds.add(Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length());
        });
        return threadIds;
    }
}
