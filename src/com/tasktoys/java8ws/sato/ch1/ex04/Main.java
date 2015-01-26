package com.tasktoys.java8ws.sato.ch1.ex04;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		File[] files = (new File("./")).listFiles(f -> true);
		Arrays.sort(files, (File f1, File f2) -> {
			if (f1.isDirectory() && !f2.isDirectory())
				return -1;
			else if (!f1.isDirectory() && f2.isDirectory())
				return 1;
			else
				return f1.getName().compareTo(f2.getName());
			});
		System.out.println(Arrays.toString(files));
	}

}
