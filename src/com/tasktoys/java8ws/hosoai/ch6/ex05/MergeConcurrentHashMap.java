package com.tasktoys.java8ws.hosoai.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeConcurrentHashMap {
	private static final int THREADS = 2;
	private final ConcurrentHashMap<String, Set<File>> wordHashMap = new ConcurrentHashMap<>();
	
	class WordCorrector extends Thread{
		Set<File> files;
		public WordCorrector(Set<File> files){
			this.files = files;
		}
		@Override
		public void run() {
			for(File file :files){
				HashSet<File> fileSet = new HashSet<>();
				fileSet.add(file);
				try {
					Set<String> words = Files.readAllLines(Paths.get(file.getAbsolutePath()))
							.stream().flatMap(s->
								Stream.of(s.split("[\\P{L}]+"))).collect(Collectors.toSet());
					words.forEach(word -> 
						wordHashMap.merge(word, fileSet, (existSet, newValue)->{
							existSet.addAll(newValue); 
							return existSet;
						}));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void correct(Set<File> files){
		ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
		for(int i=0;i<THREADS;i++){
			executorService.submit(new WordCorrector(files));
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(String word : wordHashMap.keySet()){
			System.out.println(word +":"+wordHashMap.get(word).stream().map(f->f.getName()).collect(Collectors.joining(", ")));
		}
	}
	
	public static void main(String[] args) {
		HashSet<File> files = new HashSet<>();
		Path resourcePath = Paths.get("test", "res","ch6");
		files.add(resourcePath.resolve("alice.txt").toFile());
		files.add(resourcePath.resolve("war_and_peace.txt").toFile());
		
		new MergeConcurrentHashMap().correct(files);
	}
}
