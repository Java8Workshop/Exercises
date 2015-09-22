/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch2.ex09;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *@author mikan
 */
@RunWith(Theories.class)
public class ReduceArrayListsTest {

    @DataPoint
    public static List<ArrayList<String>> empty = new ArrayList<>();

    @DataPoint
    public static List<ArrayList<String>> source = new ArrayList<>();

    static {
        source.add(createArrayList("1-1", "1-2", "1-3"));
        source.add(createArrayList("2-1", "2-2", "2-3"));
        source.add(createArrayList("3-1", "3-2", "3-3"));
    }

    @Test(expected = NullPointerException.class)
    public void testReduceArrayLists_NPE() {
        new ReduceArrayLists<>(null);
    }

    @Theory
    public void testToArrayList1_theoryInput(List<ArrayList<String>> lists) {
        ArrayList<String> reduced = new ReduceArrayLists<>(lists.stream()).toArrayList1();
        assertThat(reduced, is(simpleCombine(lists)));
    }

    @Theory
    public void testToArrayList2_theoryInput(List<ArrayList<String>> lists) {
        ArrayList<String> reduced = new ReduceArrayLists<>(lists.stream()).toArrayList2();
        assertThat(reduced, is(simpleCombine(lists)));
    }

    @Theory
    public void testToArrayList3_theoryInput(List<ArrayList<String>> lists) {
        ArrayList<String> reduced = new ReduceArrayLists<>(lists.stream()).toArrayList3();
        assertThat(reduced, is(simpleCombine(lists)));
    }

    @SafeVarargs
    private static <E> ArrayList<E> createArrayList(E... elements) {
        ArrayList<E> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }

    private static <E> ArrayList<E> simpleCombine(List<ArrayList<E>> lists) {
        ArrayList<E> result = new ArrayList<>();
        lists.forEach(result::addAll);
        return result;
    }
}
