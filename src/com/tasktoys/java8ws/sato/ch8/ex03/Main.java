package com.tasktoys.java8ws.sato.ch8.ex03;

public class Main {

	public static void main(String[] args) {
		test(72, 16);
		test(-72, 16);
		test(72, -16);
		test(-72, -16);
	}
	
	public static void test(int a, int b) {
		System.out.println("gcd(" + a + "," + b + ") are");
		System.out.println("% " + gcd(a, b));
		System.out.println("floorMod " + gcdFloorMod(a, b));
		System.out.println("rem " + gcdRem(a, b) + "\n");
	}
	
	public static int gcd(int a, int b) {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, (a % b));
			}
	}

	public static int gcdFloorMod(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, Math.floorMod(a, b));
		}
	}
	
	public static int gcdRem(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, rem(a, b));
		}
	}
	
	public static int rem(int a, int b) {
		int x = (int)(a / b) * b;
		if (a < 0) {
			return x - a;
		} else {
			return a - x;
		}
	}
}
