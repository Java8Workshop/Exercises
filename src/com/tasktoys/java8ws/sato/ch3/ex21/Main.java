package com.tasktoys.java8ws.sato.ch3.ex21;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Supplier<String> s = () -> {
			int n = (int)(Math.random() * 100);
			String str = "";
			for (int j = 0; j < n; j++) {
				str += "a";
			}
			return str;
		};
		Function<String, Integer> func = str -> str.length();
		
		Future<String> future1 = CompletableFuture.supplyAsync(s);
		Future<Integer> future2 = map(future1, func);
		
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static <T, U> Future<U> map(Future<T> fu, Function<T, U> f) {
		return new MyFuture<T, U>(fu, f);
	}


}
