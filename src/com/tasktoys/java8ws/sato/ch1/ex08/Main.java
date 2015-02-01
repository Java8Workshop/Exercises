package com.tasktoys.java8ws.sato.ch1.ex08;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name: names)
			runners.add(() -> System.out.println(name));
		
		runners.stream().forEach(r -> r.run());
		runners.clear();
		
		//for (int i = 0; i < names.length; i++) {
		//	runners.add(() -> System.out.println(names[i]));			
		//}
		//runners.stream().forEach(r -> r.run());
	}

}
