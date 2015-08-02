package com.tasktoys.java8ws.mrbearing.ch6.ex3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;import java.util.stream.IntStream;


public class AtomiLongConter {
	public static void main(String[] args) throws InterruptedException {
		AtomicLong along = new AtomicLong();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<1000; i++)
			threads.add(new Thread(()-> {
				for(int a=0; a<1000000; a++)
					along.incrementAndGet();
				}));
		Instant start = Instant.now();
		threads.forEach(t-> t.start());
		threads.forEach(t-> {
			try {
				t.join();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} );
		Instant end = Instant.now();
		Duration time = Duration.between(start, end);
		long timeMs = time.toMillis();
		System.out.println("time "+timeMs+"ms");







	}
}
