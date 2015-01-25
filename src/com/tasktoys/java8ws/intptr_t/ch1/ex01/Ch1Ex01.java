package com.tasktoys.java8ws.intptr_t.ch1.ex01;

import java.util.Arrays;
import java.util.Comparator;

public class Ch1Ex01 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("called:" + Thread.currentThread().getName());
		Arrays.sort(new Integer[]{0, 1}, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println( "comparator thread=" + Thread.currentThread().getName() );
				return o1.compareTo(o2);
			}
		});

		Thread th = new Thread(() ->{
			System.out.println( "if called by other thread=" + Thread.currentThread().getName() );
		});
		th.start();
		th.join();
	}
}
