package com.tasktoys.java8ws.hosoai.ch2.ex05;

import java.util.stream.Stream;

public class InfiniteRandomStream {
	public static void main(String[] args) {
		LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();
		Stream.iterate(100L, lcg::getNext).limit(10).forEach(System.out::println);;
	}	
}

class LinearCongruentialGenerator{
	long a = 25214903917L;
	long c = 11;
	long m = (long)Math.pow(2, 48);
		
	public long getNext(long x){
		return (a * x + c) % m;
	}
}
