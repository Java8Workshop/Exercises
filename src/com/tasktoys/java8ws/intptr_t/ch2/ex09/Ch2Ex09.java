package com.tasktoys.java8ws.intptr_t.ch2.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch2Ex09 {
	public static void main(String[] args) {
		Stream<ArrayList<Integer>> stream = Stream.of(
			arrayListOf(1, 2, 3),
			arrayListOf(4, 5, 6),
			arrayListOf(7, 8, 9)
		);

		ArrayList<Integer> aryList = reduceToArrayList(stream);
		String csv = aryList.stream()
				.map(i -> i.toString())
				.collect(Collectors.joining(", "));
		System.out.println(csv);
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
	
	/**
	 * ArrayList<T>のストリームから1つのArrayList<T>へ収集する
	 * @param stream ArrayList<T>のストリーム
	 * @return 収集したArrayList<T>
	 */
	static <T> ArrayList<T> reduceToArrayList(Stream<ArrayList<T>> stream) {
		ArrayList<T> result = stream.reduce(
				new ArrayList<>(),
				(resultList, elementList) -> {
					elementList.forEach(e -> resultList.add(e));
					return resultList;
				},
				(list1, list2) -> {
					list1.addAll(list2);
					return list1;
				});
		return result;
	}
}
