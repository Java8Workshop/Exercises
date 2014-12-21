package com.tasktoys.java8ws.sato.filevisitorscratch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class MyVisitor extends SimpleFileVisitor<Path> {

	public MyVisitor() {
		
	}
	
	@Override
	public FileVisitResult 	visitFileFailed(Path path, IOException exc) throws IOException {
		if (Files.exists(path))
			return FileVisitResult.TERMINATE;
		else
			throw exc;
	}
}
