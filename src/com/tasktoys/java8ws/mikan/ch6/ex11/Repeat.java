/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch6.ex11;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author mikan
 */
public class Repeat {

    private static final String PASSWORD = "password";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<PasswordAuthentication> future = repeat(() ->
                new PasswordAuthentication(getUserName(), getPassword()), (a) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted.");
                return false;
            }
            return PASSWORD.equals(String.valueOf(a.getPassword()));
        });
        System.out.println("OK password=" + String.valueOf(future.get().getPassword()));
    }

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenComposeAsync(w -> until.test(w) ?
                CompletableFuture.completedFuture(w) : repeat(action, until));
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("user name: ");
        return scanner.nextLine();
    }

    private static char[] getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("password: ");
        return scanner.nextLine().toCharArray();
    }
}
