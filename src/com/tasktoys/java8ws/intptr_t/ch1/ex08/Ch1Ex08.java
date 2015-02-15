package com.tasktoys.java8ws.intptr_t.ch1.ex08;

import java.util.List;
import java.util.ArrayList;

public class Ch1Ex08 {
	public static void main(String[] args) {		
		String[] names = {"Peter", "Paul", "Mary"};
		
		// 拡張forバージョン
		List<Runnable> runners = new ArrayList<>();
		for ( String name : names ) {
			runners.add(() -> System.out.println(name));
		}
		runners.stream().forEachOrdered(runner -> runner.run());
		
		// 従来のfor
		runners.clear();
		for(int i = 0; i < names.length; i++) {
			final int ii = i; // 実質的なfinalが必須
			runners.add(() -> System.out.println(names[ii]) );
		}
		runners.stream().forEachOrdered(runner -> runner.run());
	}
}
