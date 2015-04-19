package com.tasktoys.java8ws.lagunapresa.ch2.ex05;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.tasktoys.java8ws.lagunapresa.ch2.ex05.LinearCongruentialGenerator.argsOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinearCongruentialGeneratorTest {

    @Test
    public void testTypeOfStreamOfArray() throws IOException {
        Stream<Long> s = argsOf(25214903917L, 11L,
                (long) Math.pow(2, 48)).generate(0);
        assertThat(s.limit(10).collect(Collectors.toList()),
                is(Arrays.asList(11L,
                        277363943098L,
                        11718085204285L,
                        49720483695876L,
                        102626409374399L,
                        25707281917278L,
                        25979478236433L,
                        137139456763464L,
                        148267022728371L,
                        127911637363266L /* Maybe -153563339347390L is bad answer (overflowed!) */))
        );
    }

}
