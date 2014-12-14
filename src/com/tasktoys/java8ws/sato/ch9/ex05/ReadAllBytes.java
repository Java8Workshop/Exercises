package com.tasktoys.java8ws.sato.ch9.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadAllBytes {

	public static void main(String[] args) {
		Path inputPath = Paths.get("./out/ch9ex05in.txt");
		Path outputPath = Paths.get("./out/ch9ex05out.txt");
		try {
			byte[] bytes = Files.readAllBytes(inputPath);
			int size = bytes.length;
			byte[] rev = new byte[size];
			for (int i = 0; i < size; i++) {
				rev[i] = bytes[size - i - 1];
			}
			Files.write(outputPath, rev);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
