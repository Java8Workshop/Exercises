package com.tasktoys.java8ws.lagunapresa.ch3.ex07;

import java.util.Comparator;

public class StringComparators {

    public static Comparator<String> generate(boolean ascending, boolean caseInsensitive, boolean spaceIncluded) {
        return (s1, s2) -> {
            String ss1 = ascending ? s1 : s2;
            String ss2 = ascending ? s2 : s1;
            return ignoreCase(caseInsensitive, trim(spaceIncluded, ss1), trim(spaceIncluded, ss2));
        };
    }

    static String trim(boolean pred, String s) {
        return pred ? join(s.split("\\s")) : s;
    }

    private static int ignoreCase(boolean pred, String s1, String s2) {
        return pred ? s1.compareToIgnoreCase(s2) : s1.compareTo(s2);
    }

    private static Comparator<String> reverse(boolean pred, Comparator<String> c) {
        return pred ? c.reversed() : c;
    }

    private static String join(String[] xs) {
        StringBuilder sb = new StringBuilder();
        for (String s : xs) {
            sb.append(s);
        }
        return sb.toString();
    }

    private StringComparators() {
    }

}
