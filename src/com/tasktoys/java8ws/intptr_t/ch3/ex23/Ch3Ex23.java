package com.tasktoys.java8ws.intptr_t.ch3.ex23;

import java.util.function.Function;

class Pair<T> {
	private T first;
	private T second;
	
	protected Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public static <T> Pair<T> of(T first, T second) {
		return new Pair<>(first, second);
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}

	public <R> Pair<R> map(Function<? super T, ? extends R> f) {
		return new Pair<>(f.apply(this.first), f.apply(this.second));
	}
	
	// Pairの要素は2つであるためフラット化する事ができないため「public Pair<R> flatMap(Function<T, R> f)は定義されない。
}

public class Ch3Ex23 {
	public static void main(String[] args) {
		Pair<Integer> pair = Pair.of(1, 2);
		Pair<String> mappedPair = pair.map((i) ->  i + "だよ");
		System.out.println(mappedPair);
	}
}
