package com.tasktoys.java8ws.sato.ch3.ex24;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Pair<T> {

	private T left;
	private T right;
	
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
	
	public Pair<Pair<T>> flatMap0(Function<T, Pair<T>> f) {
		return new Pair<Pair<T>>(f.apply(left), f.apply(right));
	}

	public Pair<T> flatMap1(Function<T, Pair<T>> f) {
		return f.apply(left);
	}
	
	public Pair<T> flatMap2(Function<T, Pair<T>> f) {
		return f.apply(right);
	}
	
	public Pair<T> mapFold(Function<T, Pair<T>> f, BinaryOperator<T> o) {
		Pair<T> l = f.apply(left);
		Pair<T> r = f.apply(right);
		return new Pair<T>(o.apply(l.left(), l.right()), o.apply(r.left(), r.right()));
	}
	
	public T left() {
		return left;
	}
	
	public T right() {
		return right;
	}
	
	@Override
	public String toString() {
		return "(" + left.toString() + ", " + right.toString() + ")";
	}
}
