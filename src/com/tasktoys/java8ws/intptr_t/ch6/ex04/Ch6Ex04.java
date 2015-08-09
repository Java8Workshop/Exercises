package com.tasktoys.java8ws.intptr_t.ch6.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.Random;

public class Ch6Ex04 {
	public static void main(String[] args) {
		List<Long> valueList = new ArrayList<>();
		Random rand = new Random();

		// いっぱい値を作る
		for(int i = 0; i < 10000; i++){
			valueList.add(rand.nextLong());
		}
		
		LongAccumulator longMin = new LongAccumulator(Long::min, Long.MAX_VALUE);		
        LongAccumulator longMax = new LongAccumulator(Long::max, Long.MIN_VALUE);
        valueList.parallelStream().forEach(e -> {
        	longMin.accumulate(e);
        	longMax.accumulate(e);
        });
        
        // 検算用
        Optional<Long> minTest = valueList.stream().min((a, b) -> a.compareTo(b));
        Optional<Long> maxTest = valueList.stream().max((a, b) -> a.compareTo(b));
        
        System.out.println("min: " + longMin.longValue() + " : " + (longMin.longValue() == minTest.get()));
        System.out.println("max: " + longMax.longValue() + " : " + (longMax.longValue() == maxTest.get()));
	}
}
