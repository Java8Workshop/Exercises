/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch5.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 * @author mikan
 */
public class NextDay {

    private NextDay() {
        // static use only
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate next = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println(next);
    }

    public static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        Objects.requireNonNull(predicate);
        return TemporalAdjusters.ofDateAdjuster(w -> {
            LocalDate result = w;
            do {
                result = result.plusDays(1);
            } while (predicate.negate().test(result));
            return result;
        });
    }
}
