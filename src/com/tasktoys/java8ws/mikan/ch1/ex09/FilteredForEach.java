/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.mikan.ch1.ex09;

/**
 *
 * @author mikan
 */
public class FilteredForEach {

    public static void main(String[] args) {

        List2<String> list = new ArrayList2<>();
        list.add("mikan");
        list.add("MrBearing");
        list.add("YuichiroSato");
        list.add("namichan0801");
        list.add("LagunaPresa");
        list.add("intptr-t");
        list.add("s-hosoai");
        list.forEachIf(System.out::println, s -> !s.contains("-"));
    }
}
