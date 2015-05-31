package com.tasktoys.java8ws.mrbearing.ch3.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Ch3Ex16 {
	public static void main(String[] arg) {
		// System.out.println("hello");
		Supplier<Integer> sup1 = ()->{
			System.out.println("first");
			return 1;
		};
		BiConsumer<Integer, Throwable> bicon = (i,t)->System.out.println("second");

		doInOrderAsync(sup1, bicon,
				(t) -> System.out.println("exceptino::" + t.toString())
				);
		/*
		doInOrderAsync(
				() -> System.out.println("first"),
				() -> {
					System.out.println("second");
					},
				(t) -> System.out.println("exceptino::" + t.toString()));
		*/

	}

	public static void doInOrderAsync(Runnable first, Runnable second,
			Consumer<Throwable> handler) {
		Thread t = new Thread() {
			public void run() {
				try {
					first.run();
					second.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		t.start();
	}

	//3つ目の引数必要。2つ目の実行時に例外発生した場合に、ハンドルできない。

	public static<T > void doInOrderAsync(
			Supplier<T> first,BiConsumer<T, Throwable> second,
			Consumer<Throwable> handler){
		Thread t= new Thread(){
			public void run(){
				Throwable th = null;
				T firstResult = null;
				try{
				 firstResult = first.get();
				}catch(Throwable e){
					th = e;
				}finally{
					try{
					second.accept(firstResult, th);
					}catch(Throwable t2){
						handler.accept(t2);
					}

				}

			}
		};
		t.start();
	}
}
