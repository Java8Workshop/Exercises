package com.tasktoys.java8ws.sato.ex6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<String> fileNames = Arrays.asList("file.txt", "file2.txt", "file3.txt");
		List<File> files = toFiles(fileNames);
		makeTestFiles(files);
		readTestFiles(files);
	}
	
	public static void makeTestFiles(List<File> files) {
		for (File file : files) {
			try {
				Files.write(file.toPath(), makeRandomString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<File> toFiles(List<String> fileNames) {
		return fileNames.stream().map(fileName -> Paths.get("./out/" + fileName).toFile()).collect(Collectors.toList());
	}
	
	public static byte[] makeRandomString() {
		int n = (int)(Math.random() * 10);
		String str = "";
		for (int i = 0; i < n; i++) {
			int m = (int)(Math.random() * 10);
			for (int j = 0; j < m; j++) {
				str += makeRandomWord() + " ";
			}
			str += "\n";
		}
		return str.getBytes();
	}
	
	public static String makeRandomWord() {
		String word = "";
	    int n = (int)(Math.random() * 2) + 1;
	    for (int i = 0; i < n; i++) {
	    	switch((int)(Math.random() * 4)) {
				case 0:
					word += "a";
					break;
				case 1:
					word += "b";
					break;
				case 2:
					word += "c";
					break;
				default:
					word += "e";
			}
	    }
		return word;
	}
	
	public static void readTestFiles(List<File> files) {
		ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<String, Set<File>>();
		Thread[] threads = new Thread[files.size()];
		int i = 0;
		for (File file : files) {
			threads[i] = new WorkingThread(map, file);
			i++;
		}
		for (int j = 0; j < files.size(); j++) {
			threads[j].start();
		}
		for (int j = 0; j < files.size(); j++) {
			try {
				threads[j].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		map.forEach((key, value) -> {
			System.out.print("word " + key);
			System.out.print(" is contained in ");
			value.forEach(file -> System.out.print(file.getPath() + " "));
			System.out.println();
		});
	}
}
