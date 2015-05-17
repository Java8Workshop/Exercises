package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringComparatorsTest {

    private static final String[] STRS = {"def", "ghi", "abc", "a b c", "ABC"};

    @Test
    public void ascending() {
        test(true, false, false,
                "ABC", "a b c", "abc", "def", "ghi");
    }

    @Test
    public void descending() {
        test(false, false, false,
                "ghi", "def", "abc", "a b c", "ABC");
    }

    @Test
    public void caseInsensitive() {
        test(true, true, false,
                "a b c", "abc", "ABC", "def", "ghi");
    }

    @Test
    public void ignoreSpace() {
        test(true, true, true,
                "abc", "a b c", "ABC", "def", "ghi");
    }

    @Test
    public void testTrim() {
        assertThat(StringComparators.trim(true, "a b c"), is("abc"));
    }

    private void test(boolean ascending, boolean caseInsensitive, boolean spaceIncluded, String... expects) {
        String[] arr = STRS.clone();
        Arrays.sort(arr, StringComparators.generate(ascending, caseInsensitive, spaceIncluded));
        assertThat(Arrays.asList(arr), is(Arrays.asList(expects)));
    }

}
