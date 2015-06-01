package com.tasktoys.java8ws.hosoai.ch3.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DoInOrderAsyncWithBiConsumer<T> {
	public void doInOrderAsync(Supplier<T> first,
			BiConsumer<T, Throwable> handler) {
		Thread t = new Thread() {
			public void run() {
				T result = null;
				try {
					result = first.get();
					handler.accept(result, null);
				} catch (Throwable t) {
					handler.accept(null, t);
				}
			}
		};
		t.start();
	}
	
	public static void main(String[] args) {
		DoInOrderAsyncWithBiConsumer<String> exceptionHandling = new DoInOrderAsyncWithBiConsumer<>();
		
		exceptionHandling.doInOrderAsync(
				()->"hello?".substring(10), 
				(str, u)->{
					if(str!=null&&u==null){
						System.out.println("no Exception:"+str);
					}else{
						System.out.println("Exception occurred in Supplier");
					}
				});
		exceptionHandling.doInOrderAsync(
				()->"hello?", 
				(str, u)->{
					if(str!=null&&u==null){
						System.out.println("no Exception:"+str);
					}else{
						System.out.println("Exception occurred in Supplier");
					}
				});
	}
}
