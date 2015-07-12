package com.tasktoys.java8ws.lagunapresa.ch5.ex03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class TemporalAdjusterBuilder {

    public static TemporalAdjuster next(Predicate<LocalDate> p) {
        return TemporalAdjusters.ofDateAdjuster(w -> {
                do w = w.plusDays(1L);
                while (!p.test(w));
                return w;
            }
        );
    }

    private TemporalAdjusterBuilder() {
    }

}
