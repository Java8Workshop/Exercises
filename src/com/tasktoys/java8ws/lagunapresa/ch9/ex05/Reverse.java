package com.tasktoys.java8ws.lagunapresa.ch9.ex05;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Reverse {

	public static void main(String[] arg) throws Exception {
		byte[] bytes = Files.readAllBytes(Paths.get("README.md"));
		byte[] reversed = reverse(bytes);
		Files.write(Paths.get("out/out.txt"), reversed);
	}

	private static byte[] reverse(byte[] bytes) {
		byte[] reversed = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			reversed[bytes.length - 1 - i] = bytes[i];
		}
		return reversed;
	}

}
