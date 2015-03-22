package com.tasktoys.java8ws.sato.ch2;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Ex02 {
	
	static Logger log = Logger.getLogger("ex02");

	public static void main(String[] args) {
		List<String> words = Arrays.asList(new String[] {
				"a", "aaa", "aa", "bbbb", "ccc", "ddd", "aaa", "cc", "ddd"});
		List<String> longword = words.stream().filter(s -> {
			log.log(Level.INFO, s);
			return s.length() > 2;
		}).limit(5).collect(Collectors.toList());
		System.out.println(longword);
	}
}
