package com.tasktoys.java8ws.intptr_t.ch3.ex20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


class StreamUtil {
	public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		return list.stream().map(f).collect(Collectors.toList());
	}
}

public class Ch3Ex20 {
	public static void main(String[] args) {
		List<String> list = StreamUtil.map(Arrays.asList(1, 2, 3, 4, 5), 
			i -> "#" + String.valueOf(i * 10)
		);
		
		System.out.println(list);		
	}
}
