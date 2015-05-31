package com.tasktoys.java8ws.hosoai.ch3.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class FutureMapper<T, U> {
	public static <T, U> Future<U> map(Future<T> future, Function<T,U> func){
		try {
			return FutureFactory.getInstance(func.apply(future.get()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}	
	public static void main(String[] args) {
		// Future<String> to Future<Integer> mapping.
		Future<String> futureT = FutureFactory.getInstance("10");
		Future<Integer> futureU = FutureMapper.map(futureT, (String t)->Integer.parseInt(t));
		try {
			System.out.println(futureU.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class FutureFactory{
	public static <U> Future<U> getInstance(U u){
		return new Future<U>(){
			
			// get で関数を呼びなさい・・の意図がよく分からんです．．
			private U function(U u){
				return u;
			}
			
			@Override
			public boolean cancel(boolean arg0) {
				return false;
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {				
				return function(u);
			}

			@Override
			public U get(long arg0, TimeUnit arg1) throws InterruptedException,
					ExecutionException, TimeoutException {
				return function(u);
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}
		};
	}
}