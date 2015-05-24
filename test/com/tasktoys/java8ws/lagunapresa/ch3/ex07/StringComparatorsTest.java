package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static com.tasktoys.java8ws.lagunapresa.ch3.ex07.StandardComparisons.*;

public class StringComparatorsTest {

    private static final String[] STRS = {"def", "ghi", "abc", "a b c", "ABC"};

    @Test
    public void ascending() {
        test(Arrays.asList("ABC", "a b c", "abc", "def", "ghi"));
    }

    @Test
    public void descending() {
        test(Arrays.asList("ghi", "def", "abc", "a b c", "ABC"),
                DESCENDING);
    }

    @Test
    public void caseInsensitive() {
        test(Arrays.asList("a b c", "abc", "ABC", "def", "ghi"),
                CASE_INSENSITIVE);
    }

    @Test
    public void caseInsensitive_whiteInsensitive() {
        test(Arrays.asList("abc", "a b c", "ABC", "def", "ghi"),
                CASE_INSENSITIVE,
                WHITE_INSENSITIVE);
    }

    @Test
    public void descending_caseInsensitive_whiteInsensitive() {
        test(Arrays.asList("ghi", "def", "abc", "a b c", "ABC"),
                DESCENDING,
                CASE_INSENSITIVE,
                WHITE_INSENSITIVE);
    }

    private void test(List<String> expects, Comparison... cs) {
        String[] arr = STRS.clone();
        Arrays.sort(arr, StringComparators.generate(cs));
        assertThat(Arrays.asList(arr), is(expects));
    }

}
