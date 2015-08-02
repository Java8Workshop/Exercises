package com.tasktoys.java8ws.hosoai.ch6.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/*
 * Output:
 *  LongAdder :4729
 *  result value : 100000000
 *  AtomicLongAdder :2417
 *  result value : 100000000
 *  ManuallyLongAdder :1752
 *  result value : 100000000
 */
public class LongAdderBenchmark {
	private static final int NUM_OF_THREAD = 1000;
	public static final int INCREMENTS = 100000;

	public static void main(String[] args) {
		Instant start = Instant.now();
		LongAdderThread[] threads = new LongAdderThread[NUM_OF_THREAD];
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			threads[i] = new LongAdderThread();
			threads[i].start();
		}
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Instant end = Instant.now();
		System.out.println("LongAdder :"
				+ Duration.between(start, end).toMillis());
		System.out.println("result value : " + LongAdderThread.largest);

		start = Instant.now();
		AtomicLongAdderThread[] atomicThreads = new AtomicLongAdderThread[NUM_OF_THREAD];
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			atomicThreads[i] = new AtomicLongAdderThread();
			atomicThreads[i].start();
		}
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				atomicThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		end = Instant.now();
		System.out.println("AtomicLongAdder :"
				+ Duration.between(start, end).toMillis());
		System.out.println("result value : " + AtomicLongAdderThread.largest);

		start = Instant.now();
		LongManuallyAdderThread[] manuallyThreads = new LongManuallyAdderThread[NUM_OF_THREAD];
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			manuallyThreads[i] = new LongManuallyAdderThread();
			manuallyThreads[i].start();
		}
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				manuallyThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		end = Instant.now();
		System.out.println("ManuallyLongAdder :"
				+ Duration.between(start, end).toMillis());
		System.out.println("result value : " + AtomicLongAdderThread.largest);
	}
}

class AtomicLongAdderThread extends Thread {
	public static AtomicLong largest = new AtomicLong();

	@Override
	public void run() {
		for (int i = 0; i < LongAdderBenchmark.INCREMENTS; i++) {
			largest.getAndIncrement();
		}
	}
}

class LongAdderThread extends Thread {
	public static LongAdder largest = new LongAdder();

	@Override
	public void run() {
		for (int i = 0; i < LongAdderBenchmark.INCREMENTS; i++) {
			incrementLargest();
		}
	}

	synchronized public static void incrementLargest() {
		largest.increment();
	}
}

class LongManuallyAdderThread extends Thread {
	public static long largest = 0;

	@Override
	public void run() {
		for (int i = 0; i < LongAdderBenchmark.INCREMENTS; i++) {
			incrementLargest();
		}
	}

	synchronized public static void incrementLargest() {
		largest++;
	}
}
