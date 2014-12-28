package com.tasktoys.java8ws.sato.filevisitorscratch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Scratch {

	public static void main(String[] args) {

		MyVisitor v = new MyVisitor("MyVisitor.java");
		
		Path path = Paths.get("./README.md");
		try {
			v.postVisitDirectory(path, new IOException());
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileVisitResult result1 = v.visitFileFailed(path, new IOException());
		System.out.println(result1);
		
		try {
			Path result = Files.walkFileTree(Paths.get("./README.md"), v);
			System.out.println(result + " " + v.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Path result = Files.walkFileTree(Paths.get("./src/com/tasktoys/java8ws/sato/filevisitorscratch/"), v);
			System.out.println(result + " " + v.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

