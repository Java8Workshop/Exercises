package com.tasktoys.java8ws.hosoai.ch1.ex07;

public class AndThen {
	public static Runnable andThen(Runnable first, Runnable second){	
		return ()->{first.run();second.run();};
	}
	
	public static void main(String[] args) {
		andThen(()->System.out.println("first called"), ()->System.out.println("second called")).run();
	}
}
