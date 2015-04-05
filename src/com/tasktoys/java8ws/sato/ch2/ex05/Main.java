package com.tasktoys.java8ws.sato.ch2.ex05;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<Long> rad = randomStream(123l);
		rad.limit(10).forEach(i -> System.out.println(i));
	}

	static long a = 25214903917l;
	static long c = 11;
	static long pow2_8 = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2;
	static long pow2_24 = pow2_8 * pow2_8 * pow2_8;
	static long m = pow2_24 * pow2_24;
			
	public static Stream<Long> randomStream(Long seed) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}
}
