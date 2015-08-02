package com.tasktoys.java8ws.mrbearing.ch6.ex4;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class SerchMINMAX {

	public static void main(String[] args) {
		ArrayList<Long> longList = new ArrayList<Long>();
		//Random r = new Random(System.currentTimeMillis());

		for(int i=0;i<100; i++)
			longList.add(new Long(i));

		longList.forEach((a)->{
			System.out.print(a.toString()+",");
		});
		System.out.println();
		//max
		LongAccumulator maxAcum = new LongAccumulator(
				(x,y)->{
					return (x > y) ? x :y;
				}, 0 );

		longList.forEach(maxAcum::accumulate);
		System.out.println("max:"+maxAcum.get());

		//min
		LongAccumulator minAcum = new LongAccumulator(
				(x,y)->{
					return (x < y) ? x :y;
				}, 0 );

		longList.forEach(minAcum::accumulate);
		System.out.println("min:"+minAcum.get());

	}

}
