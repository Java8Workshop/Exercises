package com.tasktoys.java8ws.intptr_t.ch8.ex04;

import java.math.BigInteger;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class Ch4Ex04 {
	private static long M = 25214903917L;
	private static long N = 0x0000ffffffffffffL + 1L; //(long)Math.pow(2, 48);
	private static long A = 11;
	private static long V = 246154705703781L;
	
	public static void main(String[] args) {
		// 問題文の計算結果となるか確認
		System.out.println(next(0));
		long testSeed = prev(prev(prev(0))) ^ M;
		System.out.println(testSeed);
		Random generator = new Random(testSeed); // == new Random(164311266871034L);
		System.out.println(generator.nextDouble());
		System.out.println(generator.nextDouble());

		// 逆関数(prev)が正しいかチェック (最大値=2^48)
		System.out.println( String.format("%x, %x, %x, %x", next(prev(0)), next(prev(Long.MAX_VALUE)), prev(next(0)), prev(next(Long.MAX_VALUE))) );
		System.out.println();

		// 最小のシート値を求める
		long seed[] = {0L};
		OptionalLong min = LongStream.generate(() -> {
			seed[0] = prev(seed[0]);
			return seed[0] ^ M;
		})
		.limit(1000000L)
		.min();
		System.out.println("min:" + min.getAsLong());

		// 376050回呼び出した後に0を得るかチェック
   		Random rand = new Random(min.getAsLong());
		OptionalDouble ans =  DoubleStream.generate(() -> {
			return rand.nextDouble();
		})
		.skip(376050 - 1) // -1 := findFirstの1回分引く
		.findFirst();
		
		System.out.println(ans.getAsDouble());
	}
	
	static long next(long s) {
		//return (s * M + A) % N;
		return BigInteger.valueOf(s)
						 .multiply(BigInteger.valueOf(M))
						 .add(BigInteger.valueOf(A))
						 .mod(BigInteger.valueOf(N))
						 .longValue();
	}

	static long prev(long s) {
		//return (s - A) * V % N;
		return BigInteger.valueOf(Math.subtractExact(s, A))
						 .multiply(BigInteger.valueOf(V))
						 .mod(BigInteger.valueOf(N))
						 .longValue();
	}
}
