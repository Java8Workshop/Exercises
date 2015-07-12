package com.tasktoys.java8ws.lagunapresa.ch5.ex03;

import org.junit.Test;

import java.time.LocalDate;

import static com.tasktoys.java8ws.lagunapresa.ch5.ex03.TemporalAdjusterBuilder.next;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TemporalAdjusterBuilderTest {

    @Test
    public void test() {
        assertThat(
            LocalDate.of(2015, 7, 12).with(next(w -> w.getDayOfMonth() == 13)),
            is(LocalDate.of(2015, 7, 13)));
        assertThat(
            LocalDate.of(2015, 7, 12).with(next(w -> w.getDayOfMonth() == 12)),
            is(LocalDate.of(2015, 8, 12)));
    }

}