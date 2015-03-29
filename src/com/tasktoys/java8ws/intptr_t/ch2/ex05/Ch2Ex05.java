package com.tasktoys.java8ws.intptr_t.ch2.ex05;

import java.util.stream.Stream;

public class Ch2Ex05 {
	public static void main(String[] args) {
		long seed = 0;
		
		long a = 25214903917L;
		long c = 11;
		long m = 281474976710656L;	// 2**48		
		
		Stream<Long> rand = makeLcgRand(seed, a, c, m);		
		rand.limit(10).forEach(System.out::println);
	}
	
	/**
	 * 線形合同生成機(Linear Congruential Generator)を用いた、疑似乱数ストリームを生成する。
	 * @param seed 初期値
	 * @param a
	 * @param c
	 * @param m 最大周期
	 * @return
	 */
	public static Stream<Long> makeLcgRand(long seed, long a, long c, long m) {
		return Stream.iterate(seed, x -> (a*x + c) % m );
	}
}
