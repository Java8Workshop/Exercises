package com.tasktoys.java8ws.sato.ch3.ex23;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Pair<T> {

	T left;
	T right;
	
	public Pair(T left, T right) {
		this.left = left;
		this.right = right;
	}
	
	public Pair<T> map(Function<T,T> f) {
		return new Pair<T>(f.apply(left), f.apply(right));
	}
	
	public Pair<T> map(UnaryOperator<T> f) {
		return new Pair<T>(f.apply(left), f.apply(right));
	}
	
	@Override
	public String toString() {
		return "(" + left.toString() + ", " + right.toString() + ")";
	}
}
