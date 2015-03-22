package com.tasktoys.java8ws.sato.ch1.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayList2() {
		super();
	}
	
	@SafeVarargs
	public ArrayList2(E... args) {
		super();
		for (E arg : args) {
			this.add(arg);
		}
	}
}
