package com.tasktoys.java8ws.sato.ch3.ex07;

import java.util.Comparator;

import com.tasktoys.java8ws.sato.ch3.ex07.ComparatorBuilder.OPTION;

public class Main {

	public static void main(String[] args) {
		ComparatorBuilder builder = ComparatorBuilder.getNewBuilder();
		Comparator<String> comparator1 = builder.add(OPTION.UPSIDEDOUN).build();
		System.out.println(comparator1.compare("aaab", "aa") == "baaa".compareTo("aa"));
		System.out.println(comparator1.compare("aa", "aaab") == "aa".compareTo("baaa"));

		builder = ComparatorBuilder.getNewBuilder(OPTION.TOLOWERCASE);
		Comparator<String> comparator2 = builder.add(OPTION.UPSIDEDOUN).build();
		System.out.println(comparator2.compare("TAB", "tab") == "bat".compareTo("bat"));
		System.out.println(comparator2.compare("taB", "tab") == "bat".compareTo("bat"));

		builder = ComparatorBuilder.getNewBuilder(OPTION.TOLOWERCASE, OPTION.REMOVEWHITESPACE);
		Comparator<String> comparator3 = builder.build();
		System.out.println(comparator3.compare("Let it  be", "letitbe") == "letitbe".compareTo("letitbe"));
		System.out.println(comparator3.compare("letitbe", "LET iT  be") == "letitbe".compareTo("letitbe"));
	}
	
}
