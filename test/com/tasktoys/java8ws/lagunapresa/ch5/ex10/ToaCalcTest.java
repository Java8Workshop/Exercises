package com.tasktoys.java8ws.lagunapresa.ch5.ex10;

import org.junit.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ToaCalcTest {
    @Test
    public void test() {
        ZonedDateTime dep = ZonedDateTime.of(2013, 10, 26, 23, 30, 0, 0, ZoneId.of("Europe/Berlin"));
        ZonedDateTime answer = ToaCalc.calc(
            dep,
            Duration.ofMinutes(650L),
            ZoneId.of("Europe/Berlin"));
        System.out.println(dep);
        ZonedDateTime expects = ZonedDateTime.of(2013, 10, 27, 10, 20, 0, 0, ZoneId.of("Europe/Berlin"));
        System.out.println(expects);
//        assertThat(answer, is(expects));
        System.out.println(dep.plusMinutes(650L));
    }
}