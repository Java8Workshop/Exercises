package com.tasktoys.java8ws.intptr_t.ch1.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T> {
	default void forEachIf(Consumer<T> action,Predicate<T> filter){
		this.forEach( ( e ) ->{
			if(filter.test(e)){
				action.accept(e);
			}
		});
	}
}

class ArrayListEx<T> extends ArrayList<T> implements Collection2<T> {
	private static final long serialVersionUID = -7092943011550692060L;
}

public class Ch1Ex09 {
	public static void main(String[] args) {
		// 0〜9のリストを生成
		ArrayListEx<Integer> list = new ArrayListEx<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		/* Java8っぽく生成する場合。。。
		ArrayListEx<Integer> list = Stream
				.iterate(1, i -> i+1 )
				.limit( 10 )
				.collect( ArrayListEx<Integer>::new,
						  (ary,e) -> ary.add(e),
						  (ary1,ary2) -> ary1.addAll(ary2) );
		*/
		
		// 偶数だけ表示
		list.forEachIf(System.out::println, i -> i % 2 == 0 );
	}
}
