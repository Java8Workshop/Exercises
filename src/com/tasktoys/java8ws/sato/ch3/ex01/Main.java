package com.tasktoys.java8ws.sato.ch3.ex01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		Logger log = Logger.getLogger("log");
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		for (int j = 0; j < 12; j++) {
			final int i = j;
			logIf(log, Level.INFO, () -> i == 10, () -> "a[10] == " + a[10]);
		}
	}
	
	public static void logIf(Logger l, Level level, Supplier<Boolean> p, Supplier<String> message) {
		if (level != Level.OFF) {
			if(p.get()) {
				l.log(level, message.get());
			}
		}
	}

}
