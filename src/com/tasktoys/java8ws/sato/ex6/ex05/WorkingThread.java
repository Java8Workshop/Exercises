package com.tasktoys.java8ws.sato.ex6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class WorkingThread extends Thread {

	ConcurrentHashMap<String, Set<File>> map;
	File file;
	
	public WorkingThread(ConcurrentHashMap<String, Set<File>> map, File file) {
		this.map = map;
		this.file = file;
	}
	
	public void run() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
			lines.stream().forEach(
					words -> Arrays.stream(words.trim().split(" ")).forEach(
							word -> {
								if (!map.containsKey(word)) {
									map.put(word, ConcurrentHashMap.newKeySet());
								} 
								map.get(word).add(file);
							}));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
