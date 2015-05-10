package com.tasktoys.java8ws.intptr_t.ch3.ex01;

import java.util.Arrays;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Ch3Ex01 {	
	static final Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		// ルートログ配下の、レベル設定を全てFINESTに設定
		final Level level = Level.FINEST;
		logger.setLevel(level);
		Arrays.stream(logger.getHandlers()).forEach(hander->hander.setLevel(level));
		
		final int[] a = IntStream.range(0, 20).toArray();		
		for(int j = 0; j < a.length; j++) {
			int i = j;
			logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10] );
		}
	}

	public static <T> void logIf(Level level, BooleanSupplier pred, Supplier<String> message) {
		if(pred.getAsBoolean()) {
			logger.log(level, message.get());
		}
	}
}
