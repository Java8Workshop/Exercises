package com.tasktoys.java8ws.lagunapresa.ch3.ex16;

import org.junit.Test;

import java.util.Optional;

public class UseCaseTest {

    @Test
    public void testCase1() {
        String[] args = {"11", "1", "a"};
        for (String arg : args) {
            UseCase1.doInOrderAsync(
                () -> Integer.parseInt(arg) > 5,
                (_r, _t) -> {
                    Optional.ofNullable(_r).ifPresent(
                        r -> print("%s is%s greater than 5.", arg, r ? "" : " not")
                    );
                    Optional.ofNullable(_t).ifPresent(
                        t -> print("Error occurred: %s", t.getMessage())
                    );
                }
            );
        }
    }

    @Test
    public void testCase2() {
        String[] args = {"22", "2", "b"};
        for (String arg : args) {
            UseCase2.doInOrderAsync(
                () -> Integer.parseInt(arg) > 5,
                e -> e.accept(
                    r -> print("%s is%s greater than 5.", arg, r ? "" : " not"),
                    t -> print("Error occurred: %s", t.getMessage())
                )
            );
        }
    }

    private static void print(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

}