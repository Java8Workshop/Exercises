package com.tasktoys.java8ws.hosoai.ch2.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ParallelFor {
	static int sum=0;
	private Object lock = new Object();
	
	class Over12Counter extends Thread{
		int count = 0;
		List<String> words;
		public Over12Counter(List<String> words) {
			this.words=words;
		}
		public int getResult(){
			return count;
		}
		@Override
		public void run() {
			for(String w:words){
				if(w.length()>12){
					count++;
				}
			}
			addCount(count);
		}
	}

	public int countOver12Words(){
		int parallel = 10;
		Over12Counter[] t = new Over12Counter[parallel];
		try {
			String contents = new String(Files.readAllBytes(Paths.get("out/alice.txt")),StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));			
			int segment = words.size()/parallel+1;
			for(int i=0;i<parallel;i++){
				int upperBounds = (i+1)*segment;
				if(upperBounds>words.size()){
					upperBounds=words.size();
				}
				t[i] = new Over12Counter(words.subList(i*segment, upperBounds));
				t[i].start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	public synchronized void addCount(int count){
		sum+=count;
	}
	
	public static void main(String[] args) {
		new ParallelFor().countOver12Words();
		System.out.println(sum);
	}
}
