package com.tasktoys.java8ws.sato.ch3.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorBuilder {

	enum OPTION { UPSIDEDOUN, TOLOWERCASE, REMOVEWHITESPACE }
	
	List<OPTION> option;
	
	private Function<String, String> upsidedown = (String str) -> {
		String str2 = "";
		for (int i = str.length() - 1; 0 <= i; i--) {
			str2 += str.charAt(i);
		}
		return str2;
	};
	
	private Function<String, String> ignoreCapital = (String str) -> {
		return str.toLowerCase();
	};
	
	private Function<String, String> removeWhiteSpace = (String str) -> {
		return Arrays.stream(str.split(" ")).reduce("", (acc, str2) -> acc + str2);
	};
	
	private ComparatorBuilder(OPTION... op) {
		option = new ArrayList<>();
		for (OPTION o : op) {
			option.add(o);
		}
	}
	
	public static ComparatorBuilder getNewBuilder(OPTION... op) {
		return new ComparatorBuilder(op);
	}
	
	public ComparatorBuilder add(OPTION op) {
		option.add(op);
		return this;
	}
	
	public Comparator<String> build() {
		if (option.isEmpty()) {
			return (String str1, String str2) -> {
				return str1.compareTo(str2);
			};
		} else {
			Function<String, String> f = null;
			if (option.contains(OPTION.UPSIDEDOUN)) {
				f = f == null ? upsidedown : f.compose(upsidedown);
			}
			if (option.contains(OPTION.TOLOWERCASE)) {
				f = f == null ? ignoreCapital : f.compose(ignoreCapital);
			}
			if (option.contains(OPTION.REMOVEWHITESPACE)) {
				f = f == null ? removeWhiteSpace : f.compose(removeWhiteSpace);
			}
			final Function<String, String> g = f;
			return (String str1, String str2) -> {
				return g.apply(str1).compareTo(g.apply(str2));
			};
		}
	}
	
}
