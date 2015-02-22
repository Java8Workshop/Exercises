package com.tasktoys.java8ws.sato.ch1.ex09;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayList2<E> implements Collection2<E> {
	
	List<E> col;
	
	public ArrayList2() {
		col = new LinkedList<>();
	}
	
	@SafeVarargs
	public ArrayList2(E... args) {
		col = new LinkedList<>();
		for (E arg : args) {
			col.add(arg);
		}
	}
	
	@Override
	public void forEachIf(Consumer<E> action, Predicate<E> filter) {
		col.stream().filter(filter).forEach(action);
	}
	
	@Override
	public boolean add(E arg0) {
		return col.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return col.addAll(c);
	}

	@Override
	public void clear() {
		col.clear();
	}

	@Override
	public boolean contains(Object o) {
		return col.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return col.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return col.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return col.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return col.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return col.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return col.retainAll(c);
	}

	@Override
	public int size() {
		return col.size();
	}

	@Override
	public Object[] toArray() {
		return col.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return col.toArray(a);
	}
}
