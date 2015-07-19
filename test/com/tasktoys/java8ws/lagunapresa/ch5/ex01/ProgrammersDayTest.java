package com.tasktoys.java8ws.lagunapresa.ch5.ex01;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProgrammersDayTest {

    @Test
    public void test() {
        assertThat(ProgrammersDay.yearOf(2015), is(LocalDate.of(2015, 9, 13)));
        assertThat(ProgrammersDay.yearOf(2014), is(LocalDate.of(2014, 9, 13)));
        assertThat(ProgrammersDay.yearOf(2013), is(LocalDate.of(2013, 9, 13)));
        assertThat(ProgrammersDay.yearOf(2012), is(LocalDate.of(2012, 9, 12)));
    }

}