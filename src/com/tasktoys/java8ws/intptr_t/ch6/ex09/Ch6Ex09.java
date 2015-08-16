package com.tasktoys.java8ws.intptr_t.ch6.ex09;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Ch6Ex09 {
	public static void main(String[] args) {
		int n = 72; // 最後で誤差で計算できなくなる
		
		// 2x2の行列の配列を作成
		Matrix[] fibs = new Matrix[n];
		Arrays.parallelSetAll(fibs, i -> {
			Matrix m = new Matrix(2, 2);
			m.set(0, 0, 1);
			m.set(0, 1, 1);
			m.set(1, 0, 1);
			m.set(1, 1, 0);			
			return m;
		});
		
		// フィボナッチ数を計算
		// F^n(n=0)を除外するため、1から開始する
		Arrays.parallelPrefix(fibs, 1, fibs.length,(lhs, rhs) -> {
			return lhs.multiply(rhs);
		});
		
		// フィボナッチ数列表示
		IntStream.range(0, fibs.length).forEach(i -> {
			long ans = fibs[i].get(0, 0);
			long test = calcFibonacci(i + 1);

			System.out.println( (i + 1) + " : " + ans + " = " + test + " [" + (ans == test) +"]");
		});
	}

	//
	// 検算用
	//
	private static double SQRT_5 = Math.sqrt(5.);
	private static long calcFibonacci(int n) {
		double phi = (1. + SQRT_5) / 2.;
		double phi1 = Math.pow(phi, n);
		double phi2 = Math.pow(-phi, -n);

		return (long)((phi1 - phi2) / SQRT_5);
	}
}
