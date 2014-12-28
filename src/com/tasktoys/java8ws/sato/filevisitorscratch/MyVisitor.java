package com.tasktoys.java8ws.sato.filevisitorscratch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyVisitor extends SimpleFileVisitor<Path> {

	private Path targetFileName;
	private Boolean result;
	
	public MyVisitor(String targetFileName) {
		this.targetFileName = Paths.get(targetFileName);
		this.result = false;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes atts) {
		System.out.println("visited " + file.getFileName());
		if (file.getFileName().equals(targetFileName))
			result = true;
		return FileVisitResult.CONTINUE;
	}
	
	@Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
	
	public Boolean getResult() {
		return result;
	}
}
