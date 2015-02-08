package com.tasktoys.java8ws.hosoai.ch1.ex04;

import java.io.File;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortedFileList {
	
	public File[] dirFirstSort(File[] inputFiles){
		Comparator<File> comparator = (File f1, File f2)->f1.getPath().compareTo(f2.getPath());
		Stream<File> directories = Stream.of(inputFiles).filter(File::isDirectory).sorted(comparator);
		Stream<File> files = Stream.of(inputFiles).filter(File::isFile).sorted(comparator);
		
		return (File[])Stream.concat(directories, files).toArray(File[]::new);
	}
	
	public static int fileComparate(File f1, File f2){
		return f1.getPath().compareTo(f2.getPath());
	}
}
