package com.tasktoys.java8ws.sato.ch9.ex11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		ProcessBuilder builder1 = new ProcessBuilder("echo", "public class Hoge { public static void main(String[] args) { System.out.println(3); } }");
		builder1.redirectOutput(Paths.get("./out/Hoge.java").toFile());
		Process process = builder1.start();
		process.waitFor();
		
		if (new File("./out/Hoge.java").exists()) {
			ProcessBuilder builder2 = new ProcessBuilder("javac", "./out/Hoge.java");
			Process process2 = builder2.start();
			process2.waitFor();
			
			ProcessBuilder builder3 = new ProcessBuilder("java", "-classpath", "./out", "Hoge");
			builder3.redirectOutput(Paths.get("./out/HogeResult.txt").toFile());
			Process process3 = builder3.start();
			process3.waitFor();
		}
	}

}
