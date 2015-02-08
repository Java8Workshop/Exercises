package com.tasktoys.java8ws.hosoai.ch1.ex02;

import java.io.File;
import java.nio.file.Paths;

public class LambdaDirFilter {
	public File[] getFilteredDirectories(String dir){
		return Paths.get(dir).toFile().listFiles(f->f.isDirectory());
	}
	
	
	public File[] getFilteredDirectoriesWithFuncRef(String dir){
		return Paths.get(dir).toFile().listFiles(File::isDirectory);
	}
}
