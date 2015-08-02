package com.tasktoys.java8ws.sato.ex6.ch03;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Main {

	public static void main(String[] args) {
		System.out.println("first try");
		atomicLongVer();
		longAdderVer();
		System.out.println();
		
		System.out.println("second try");
		atomicLongVer();
		longAdderVer();
		System.out.println();
		
		System.out.println("third try");
		atomicLongVer();
		longAdderVer();
		System.out.println();
	}
	
	private static void atomicLongVer() {
		Thread[] threads = new Thread[1000];
		AtomicLong al = new AtomicLong(0L);
		for (int i = 0; i < 1000; i++) {
			threads[i] = new AtomicThread(al);
		}
		System.out.println("AtomicLong");
		long start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			threads[i].run();
		}
		for (int i = 0; i < 1000; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println("result " + al.get());
		System.out.println("time " + (end - start));
	}

	private static void longAdderVer() {
		Thread[] threads = new Thread[1000];
		LongAdder la = new LongAdder();
		for (int i = 0; i < 1000; i++) {
			threads[i] = new LongAdderThread(la);
		}
		System.out.println("LongAdder");
		long start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			threads[i].run();
		}
		for (int i = 0; i < 1000; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println("result " + la.longValue());
		System.out.println("time " + (end - start));
	}

}
