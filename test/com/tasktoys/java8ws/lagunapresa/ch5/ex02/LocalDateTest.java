package com.tasktoys.java8ws.lagunapresa.ch5.ex02;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LocalDateTest {

    @Test
    public void testAddOneYear() {
        LocalDate added1y = LocalDate.of(2000, 2, 29).plusYears(1L);

        assertThat(added1y,
            is(LocalDate.of(2001, 2, 28)));

        assertThat(added1y
                .plusYears(1L)
                .plusYears(1L)
                .plusYears(1L)
                .plusYears(1L),
            is(LocalDate.of(2005, 2, 28)));
    }

}