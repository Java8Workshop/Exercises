package com.tasktoys.java8ws.sato.ex6.ch04;

import java.util.concurrent.atomic.LongAccumulator;

public class Main {

	public static void main(String[] args) {
		maximumTest();
		minimumTest();
	}
	
	public static LongAccumulator getMaximumAccumulator() {
		return new LongAccumulator((l1, l2) -> l1 > l2 ? l1 : l2, Long.MIN_VALUE);
	}
	
	public static LongAccumulator getMinimumAccumulator() {
		return new LongAccumulator((l1, l2) -> l1 < l2 ? l1 : l2, Long.MAX_VALUE);
	}
	
	public static void maximumTest() {
		Thread[] threads = new Thread[1000];
		LongAccumulator la = getMaximumAccumulator();
		for (int i = 0; i < 1000; i++) {
			threads[i] = new WorkingThread(la, i, i * i);
			threads[i].run();
		}
		for (int i = 0; i < 1000; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("maximum test");
		System.out.println("expected " + 999 * 999);
		System.out.println("maximum " + la.get() + "\n");
	}
	
	public static void minimumTest() {
		Thread[] threads = new Thread[2000];
		LongAccumulator la = getMinimumAccumulator();
		for (int i = -1000; i < 1000; i++) {
			threads[i + 1000] = new WorkingThread(la, i * i, (2 * i) * (2 * i));
			threads[i + 1000].run();
		}
		for (int i = 0; i < 2000; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("minimum test");
		System.out.println("expected " + 0);
		System.out.println("minimum " + la.get() + "\n");
	}
}
