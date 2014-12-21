package com.tasktoys.java8ws.sato.FileVisitorScratch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Scratch {

	public static void main(String[] args) {

		MyVisitor v = new MyVisitor();
		
		Path path = Paths.get("./README.md");
		try {
			v.postVisitDirectory(path, new IOException());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileVisitResult result = v.visitFileFailed(path, new IOException());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

