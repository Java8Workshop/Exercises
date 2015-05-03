package com.tasktoys.java8ws.sato.ch3.ex9;

import java.lang.reflect.Field;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
	}

	public static <T> Comparator<T> lexicographicComparator(String... fieldNames) {
		return (T t1, T t2) -> {
			for (String name : fieldNames) {
				try {
					Field f1 = t1.getClass().getField(name);
					Field f2 = t2.getClass().getField(name);
					if (f1 == f2) {
						continue;
					}
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
			}
			return 0;
		};
	}
}
