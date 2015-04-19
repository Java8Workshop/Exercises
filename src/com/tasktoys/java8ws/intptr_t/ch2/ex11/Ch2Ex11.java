package com.tasktoys.java8ws.intptr_t.ch2.ex11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 整数とアイテムのペア
 *
 * @param <T> アイテムの型
 */
class IntPair<T> {
	private int	index;	// 要素番号
	private T 	item;	// アイテム
	
	public IntPair(int index, T item) {
		this.index = index;
		this.item = item;
	}
	
	public int getInt() {
		return this.index;
	}
	public T get() {
		return item;
	}
}

public class Ch2Ex11 {
	public static void main(String[] args) {
		// 結果格納先を生成
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(0);
		result.add(0);

		// 結果格納先と同じ数のストリームを生成
		Stream<IntPair<ArrayList<Integer>>> streams = Stream.of(
				new IntPair<>(0, arrayListOf(1, 2, 3)),
				new IntPair<>(1, arrayListOf(4, 5, 6)),
				new IntPair<>(2, arrayListOf(7, 8, 9)));

		// 各ストリームの要素の合計値を格納
		streams.forEach((e)->{
			int index = e.getInt();
			ArrayList<Integer> aryList = e.get();

			result.set(index, aryList.stream().reduce(Integer::sum).get() );
		});
		
		System.out.println(result);
	}
	
	/**
	 * ArrayList<T>を作成するための補助メソッド
	 * @param args ArrayListの要素
	 * @return ArrayList<T>
	 */
	@SafeVarargs
	static <T> ArrayList<T> arrayListOf(T...args){
		ArrayList<T> result = new ArrayList<>();
		Arrays.stream(args).forEach(e -> result.add(e));
		return result;
	}	
}
