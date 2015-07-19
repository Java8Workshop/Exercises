package com.tasktoys.java8ws.lagunapresa.ch5.ex01;

import java.time.LocalDate;
import java.util.Calendar;

public class ProgrammersDay {

    public static LocalDate yearOf(int y) {
        Calendar c = Calendar.getInstance();
        c.set(y, Calendar.JANUARY, 256);
        return LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
    }

    private ProgrammersDay() {
    }

}
