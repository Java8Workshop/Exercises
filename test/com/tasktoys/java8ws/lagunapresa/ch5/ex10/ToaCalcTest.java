package com.tasktoys.java8ws.lagunapresa.ch5.ex10;

import org.junit.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ToaCalcTest {
    @Test
    public void test() {
        ZonedDateTime dep = ZonedDateTime.of(2015, 8, 1, 15, 10, 0, 0, ZoneId.of("America/Los_Angeles"));
        ZonedDateTime answer = ToaCalc.calc(
            dep,
            Duration.ofHours(11L),
            ZoneId.of("Europe/Berlin"));
        ZonedDateTime expects = ZonedDateTime.of(2015, 8, 2, 11, 10, 0, 0, ZoneId.of("Europe/Berlin"));
        assertThat(answer, is(expects));
    }
}