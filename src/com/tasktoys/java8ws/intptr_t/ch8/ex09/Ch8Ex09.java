package com.tasktoys.java8ws.intptr_t.ch8.ex09;

import java.util.Iterator;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ch8Ex09 {
	public static void main(String[] args) {
		final String test = "1\n2.0\n3.3\t4 A 6";
		
		// 単語のストリーム
		toWordStream(new Scanner(test)).forEach(System.out::println);
		System.out.println("---");

		// 行のストリーム
		toLineStream(new Scanner(test)).forEach(System.out::println);
		System.out.println("---");
		
		// 整数のストリーム
		toIntStream(new Scanner(test)).forEach(System.out::println);
		System.out.println("---");
		
		// double値のストリーム
		toDoubleStream(new Scanner(test)).forEach(System.out::println);
	}
	
	/**
	 * スキャナを単語のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static Stream<String> toWordStream(final Scanner scan) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				scan, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}

	/**
	 * スキャナを行のストリームへ変換
	 * @param scan スキャナ
	 * @return　ストリーム
	 */
	public static Stream<String> toLineStream(final Scanner scan) {
		final Iterator<String> itr = new Iterator<String>() {
			@Override
			public boolean hasNext() {
				return scan.hasNextLine();
			}

			@Override
			public String next() {
				return scan.nextLine();
			}
		};
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				itr, Spliterator.ORDERED | Spliterator.NONNULL), false);		
	}

	/**
	 * スキャナを整数のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static IntStream toIntStream(final Scanner scan) {
		final OfInt primitiveItr = new OfInt() {
			
			@Override
			public boolean hasNext() {
				return scan.hasNextInt();
			}
			
			@Override
			public int nextInt() {
				return scan.nextInt();
			}
		};
		
		return StreamSupport.intStream(Spliterators.spliteratorUnknownSize(
				primitiveItr, Spliterator.ORDERED | Spliterator.NONNULL), false);		
	}
	
	/**
	 * スキャナをdouble値のストリームへ変換
	 * @param scan スキャナ
	 * @return ストリーム
	 */
	public static DoubleStream toDoubleStream(final Scanner scan) {
		final OfDouble primitiveItr = new OfDouble() {			
			@Override
			public boolean hasNext() {
				return scan.hasNextDouble();
			}

			@Override
			public double nextDouble() {
				return scan.nextDouble();
			}
		};
		
		return StreamSupport.doubleStream(Spliterators.spliteratorUnknownSize(
				primitiveItr, Spliterator.ORDERED | Spliterator.NONNULL), false);
	}
}
