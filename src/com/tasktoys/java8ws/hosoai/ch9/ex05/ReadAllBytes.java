package com.tasktoys.java8ws.hosoai.ch9.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadAllBytes {
	public void allRead(String inputFilePath, String outputFilePath){
		Path in = Paths.get(inputFilePath);
		Path out = Paths.get(outputFilePath);
		try {
			String[] test = new String[]{"",""};
			Arrays.asList(test);
			byte[] bytes = Files.readAllBytes(in);
			reverseArray(bytes);
			Files.write(out, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reverseArray(byte[] bytes){
		byte temp;
		int r;
		for(int i=0;i<bytes.length/2;i++){
			r = bytes.length-i-1;
			temp = bytes[r];
			bytes[r] = bytes[i];
			bytes[i] = temp;
		}
	}
}
