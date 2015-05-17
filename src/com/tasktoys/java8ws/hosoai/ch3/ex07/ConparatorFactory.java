package com.tasktoys.java8ws.hosoai.ch3.ex07;

import java.util.Comparator;

public class ConparatorFactory {
	public static void main(String[] args) {
		
		// 昇順，大文字小文字を区別する，空白を区別しない
		Comparator<String> comparator = genComparator(true, false, false);
		String a = "aaa";
		String b = "Aaa";
		String c = "Aaa ";
		System.out.println(comparator.compare(a, b));
		// 昇順，大文字小文字を区別しない，空白を区別する
		comparator = genComparator(true, true, false);
		System.out.println(comparator.compare(a, b));
		// 昇順，大文字小文字を区別しない，空白を区別しない
		comparator = genComparator(true, true, true);
		System.out.println(comparator.compare(a, c));
	}
	
	public static Comparator<String> genComparator(boolean ascendingOrder, boolean ignorecase, boolean ignoreSpace){	
		return (t,u)->{
			if (ignorecase){
				t = t.toLowerCase();
				u = u.toLowerCase();
			}
			if(ignoreSpace){
				t = t.trim();
				u = u.trim();
			}
			if(ascendingOrder){
				return t.compareTo(u);
			}else{
				return u.compareTo(t);
			}
		};
	}
}
