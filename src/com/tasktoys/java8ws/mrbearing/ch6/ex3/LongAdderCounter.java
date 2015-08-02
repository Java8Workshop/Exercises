package com.tasktoys.java8ws.mrbearing.ch6.ex3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

/**
 * longadder time :557ms
 * Atomic long time: 1846ms
 *
 */

public class LongAdderCounter {

	public static void main(String[] args) {
		LongAdder along = new LongAdder();
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<1000; i++)
			threads.add(new Thread(()-> {
				for(int a=0; a<1000000; a++)
					along.increment();;
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
