package com.tasktoys.java8ws.intptr_t.ch2.ex08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ch2Ex08 {
	public static void main(String[] args) {
		Stream<Integer> composed;
		
		// 第1引数、第2引数ともに有限ストリーム
		composed = zip(
				Stream.iterate(1, i->i+2).limit(3),
				Stream.iterate(2, i->i+2).limit(3));
		System.out.println(toCsv(composed));
		
		// 第1引数が無限ストリーム
		// 第2引数が有限ストリーム
		composed = zip(
				Stream.iterate(1, i->i+2),
				Stream.of(2, 4, 6));	
		System.out.println(toCsv(composed));

		// 第1引数が有限ストリーム
		// 第2引数が無限ストリーム
		composed = zip(
				Stream.of(1, 3, 5),
				Stream.iterate(2, i->i+2) );
		System.out.println(toCsv(composed));
	}

	static <T> String toCsv(Stream<T> stream) {
		return stream
				.map(e -> e.toString())
				.collect(Collectors.joining(","));
	}

	/**
	 * 交互に返すイテレータ
	 * @param <T>
	 */
	private static final class ZipIterator<T> implements Iterator<T> {
		private final Iterator<T> its[];
		private int index;

		@SuppressWarnings("unchecked")
		public ZipIterator(Iterator<T> it1, Iterator<T> it2) {
			this.its = (Iterator<T>[])Arrays.asList(it1, it2).toArray();
			this.index = 0;
		}
		
		@Override
		public boolean hasNext() {
			Iterator<T> it = this.its[this.index & 1];
			return it.hasNext();
		}

		@Override
		public T next() {
			Iterator<T> it = this.its[this.index & 1];
			this.index++;
			return it.next();
		}		
	}

	/**
	 * 第１、第２ストリームを交互に返すストリームを生成します。
	 * [注意] 第1ストリームと第2ストリームは、終端操作で閉じられます。
	 * 少なくとも第1、第2のどちらかが有限ストリームである必要があります。
	 * @param first 第１ストリーム
	 * @param second 第２ストリーム
	 * @return ストリーム
	 */
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		ZipIterator<T> zit = new ZipIterator<T>(first.iterator(), second.iterator());		
		Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zit, Spliterator.IMMUTABLE );
		return StreamSupport.stream(spliterator, false);
	}
}
