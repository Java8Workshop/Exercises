package com.tasktoys.java8ws.hosoai.ch2.ex05;

import java.util.stream.Stream;

/*
 * X0 = 100L
 * Results
 *  100
 *  2521490391711
 *  -253956958586946
 *  -256932786786319
 *  -262564217229400
 *  94254738963091
 *  104947696648866
 *  243277075933957
 *  84767341874988
 *  -139136472121913
 * 
 */

public class InfiniteRandomStream {
	public static void main(String[] args) {
		System.currentTimeMillis();
		Stream.iterate(100L, LinearCongruentialGenerator::getNext).limit(10).forEach(System.out::println);;
	}
}

class LinearCongruentialGenerator{
	static long a = 25214903917L;
	static long c = 11;
	static long m = (long)Math.pow(2, 48);
		
	public static long getNext(long x){
		return (a * x + c) % m;
	}
}
