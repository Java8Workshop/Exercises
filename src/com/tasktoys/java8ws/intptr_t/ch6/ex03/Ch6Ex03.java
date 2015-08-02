package com.tasktoys.java8ws.intptr_t.ch6.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ch6Ex03 {
	private static final int MAX_THREAD = 1000;
	private static final int ADD_COUNT = 1000000;
	
	public static void main(String[] args) {
		
		Duration test1 = evalThreadTimes(new AtomicLong(), value -> value.incrementAndGet(), value -> value.get());
		Duration test2 = evalThreadTimes(new LongAdder(), value -> value.increment(), value -> value.longValue());		
		
		System.out.println("AtomicLong: " + test1.toMillis() + "[ms]");
		System.out.println("LongAddr  : " + test2.toMillis() + "[ms]");		
		System.out.println();
		
		// 入れ替えて実施		
		test2 = evalThreadTimes(new LongAdder(), value -> value.increment(), value -> value.longValue());		
		test1 = evalThreadTimes(new AtomicLong(), value -> value.incrementAndGet(), value -> value.get());
		
		System.out.println("AtomicLong :" + test1.toMillis() + "[ms]");		
		System.out.println("LongAddr   :" + test2.toMillis() + "[ms]");
	}
	
	private static<T> Duration evalThreadTimes(T instance, Consumer<T> action, Function<T, Long> tester) {
		Thread[] threads = makeThreads(instance, action);
		
		Duration duration = calcRunningTime(threads);

		if( tester.apply(instance) != (MAX_THREAD * ADD_COUNT) ) {
			throw new RuntimeException("競合!");
		}
		
		return duration;
	}
	
	private static<T> Thread[] makeThreads(T instance, Consumer<T> action ) { 
		Thread threads[] = new Thread[MAX_THREAD];
		
		for(int i = 0; i < MAX_THREAD; i++) {
			threads[i] = new Thread(() -> {
				for(int j = 0; j < ADD_COUNT; j++) {
					action.accept(instance);
				}
			});
		}
		
		return threads;
	}
	
	private static Duration calcRunningTime(Thread[] threads) {
		Instant start = Instant.now();
		
		Arrays.stream(threads).forEach(thread ->  thread.start());
		Arrays.stream(threads).forEach(thread -> {
			try {
				thread.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		Instant end = Instant.now();
		return Duration.between(start, end);
	}	
}
