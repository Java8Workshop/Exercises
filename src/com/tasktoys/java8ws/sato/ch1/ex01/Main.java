package com.tasktoys.java8ws.sato.ch1.ex01;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {0, -3, 2, 1, 9, 4, -3, 4, 3};

		print(array);
		sort(array.clone());
		sort2(array.clone());
	}
	
	public static void sort(Integer[] array) {
		Arrays.sort(array);
		print(array);
	}
	
	public static void sort2(Integer[] array) {
		Arrays.sort(array, (f,s) -> { System.out.println(Thread.currentThread().getName()); return Integer.compare(f * f, s * s); });
		print(array);
	}
	
	public static void print(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
