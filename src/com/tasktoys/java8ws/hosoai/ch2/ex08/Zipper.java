package com.tasktoys.java8ws.hosoai.ch2.ex08;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Zipper {
	boolean toggleStream = true;
	
	public static void main(String[] args) {
		Zipper main = new Zipper();
		Stream<Integer> resultStream = main.zipper(Stream.of(0,2,4,6,8,10), Stream.of(1,3,5,7,9,11,13,15));
		resultStream.forEach(System.out::println);
	}
	
	public <T> Stream<T> zipper(Stream<T> first, Stream<T> second){	
		Supplier<T> zippedSupplier = new ZippedSupplier<T>(first.iterator(), second.iterator());
		return Stream.generate(zippedSupplier);
	}	
	
	class ZippedSupplier<T> implements Iterator<T>, Supplier<T> {
		private Iterator<T> first, second;
		private boolean toggleFirst=true;
		public ZippedSupplier(Iterator<T> first, Iterator<T> second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public boolean hasNext() {
			if(toggleFirst){
				return first.hasNext();
			}else{
				return second.hasNext();
			}
		}

		@Override
		public T next() {
			if(toggleFirst){
				toggleFirst = !toggleFirst;
				return first.next();
			}else{
				toggleFirst = !toggleFirst;
				return second.next();
			}
		}	
		
		@Override
		public T get() {
			if(this.hasNext()){				
				return null;
			}
			return this.next();
		}
	}
}
