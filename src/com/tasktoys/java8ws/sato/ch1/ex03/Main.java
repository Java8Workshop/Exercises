package com.tasktoys.java8ws.sato.ch1.ex03;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File[] files = getFilesWithExtension(new File("./"), "md");
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
	}

	public static File[] getFilesWithExtension(File file, String extension) {
		return file.listFiles(f -> f.getName().endsWith(extension));
	}
}
