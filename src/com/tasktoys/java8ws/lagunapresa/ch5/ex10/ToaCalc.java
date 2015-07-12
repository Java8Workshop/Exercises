package com.tasktoys.java8ws.lagunapresa.ch5.ex10;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ToaCalc {

    public static ZonedDateTime calc(ZonedDateTime departure, Duration d, ZoneId destination) {
        return departure.plus(d).withZoneSameInstant(destination);
    }

    private ToaCalc() {

    }

}
