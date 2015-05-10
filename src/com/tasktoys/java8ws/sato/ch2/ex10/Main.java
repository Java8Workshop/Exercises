package com.tasktoys.java8ws.sato.ch2.ex10;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<Double> stream = Stream.of(0.0,0.5,1.0,0.5,0.0,1.0);
		System.out.println(average(stream));
	}

	public static Double average(Stream<Double> stream) {
		double[] res = stream.map(d -> {
			double[] a = new double[2];
			a[0] = d;
			a[1] = 0;
			return a;
		}).reduce(new double[] { 0.0, 0.0 }, (a, b) -> {
			double [] c = new double[2];
			c[0] = a[0] + b[0];
			c[1] = a[1] + 1;
			return c;
		});
		return res[0] / res[1];
	}
}
