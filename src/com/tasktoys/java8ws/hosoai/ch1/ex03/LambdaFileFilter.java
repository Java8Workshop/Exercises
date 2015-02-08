package com.tasktoys.java8ws.hosoai.ch1.ex03;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LambdaFileFilter {
	public File[] getFilteredFiles(String dir, String ext){
		Path path = Paths.get(dir);
		return path.toFile().listFiles(file->!file.isDirectory()&&file.getName().substring(file.getName().lastIndexOf(".")).endsWith(ext));
	}
}
