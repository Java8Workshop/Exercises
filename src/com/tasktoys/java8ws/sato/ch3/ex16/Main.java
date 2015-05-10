package com.tasktoys.java8ws.sato.ch3.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<Double> s1 = () -> 4.0 / Double.valueOf("hoge");
		Supplier<Double> s2 = () -> 4.0 / 2.0;
		BiConsumer<Double, Throwable> c = (d, t) -> {
			if (d != null) {
				System.out.println("diviation " + d);
			} else if (t != null) {
				System.out.println("exception");
			}
		};
		doInOrderAsync(s1, c);
		doInOrderAsync(s2, c);
	}

	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
		(new Thread(() -> {
			try {
				T result = first.get();
				second.accept(result, null);
			} catch (Throwable t) {
				second.accept(null, t);
			}
		})).start();
	}
}
