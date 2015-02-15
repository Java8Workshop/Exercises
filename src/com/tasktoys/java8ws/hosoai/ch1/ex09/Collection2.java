package com.tasktoys.java8ws.hosoai.ch1.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T>{
	public default void forEachIf(Consumer<T> action, Predicate<T> filter){
		stream().forEach(t->{
			if(filter.test(t)){
				action.accept(t);
			}
		});
	}
}
class ArrayList2<E> extends ArrayList<E> implements Collection2<E>{
	private static final long serialVersionUID = 1L;
}
