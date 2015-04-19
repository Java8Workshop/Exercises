package com.tasktoys.java8ws.intptr_t.ch2.ex07;

import java.util.Spliterator;
import java.util.stream.Stream;

public class Ch2Ex07 {
	public static void main(String[] args) {
		Stream<Integer> finstream = Stream.of(1, 2, 3);
		Stream<Integer> infstream = Stream.iterate(0, i -> i + 1);

		boolean finite = isFinite(finstream);
		boolean infinite = isFinite(infstream);

		System.out.println( "有限:" + finite );
		System.out.println( "有限でない:" + infinite );
		
		try {
			System.out.println(infstream.count());
		} catch(IllegalStateException ex) {
			System.out.println("ストリームは終端操作済みです。");
			System.out.println(ex);
		}
	}
	
	/**
	 * ストリームが有限か判定します。
	 * [注意]ストリームは終端操作で閉じてしまいます！
	 * @param stream 判定ストリーム
	 * @return 有限の場合true、無限の場合falseを返します。
	 */
	public static <T> boolean isFinite(Stream<T> stream) {
		Spliterator<T> splitator = stream.spliterator();
				
		if(splitator.estimateSize() == Long.MAX_VALUE) {
			return false;
		} else {
			return true;
		}
	}
}
