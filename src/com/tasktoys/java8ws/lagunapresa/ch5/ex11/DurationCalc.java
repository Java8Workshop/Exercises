package com.tasktoys.java8ws.lagunapresa.ch5.ex11;

import java.time.Duration;
import java.time.ZonedDateTime;

public class DurationCalc {

    public static Duration calc(ZonedDateTime departure, ZonedDateTime arrival) {
        return Duration.between(departure, arrival);
    }

    private DurationCalc() {
    }

}
