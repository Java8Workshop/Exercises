package com.tasktoys.java8ws.lagunapresa.ch1.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryTraversaler {

	public List<File> listDir(File baseDir) {
		List<File> ls = new ArrayList<>();
		List<File> childs = Arrays.asList(baseDir.listFiles(File::isDirectory));
		ls.addAll(childs);
		for (File child : childs) {
			ls.addAll(listDir(child));
		}
		return ls;
	}

	// メソッド参照じゃないほう
	public List<File> listDir2(File baseDir) {
		List<File> ls = new ArrayList<>();
		List<File> childs = Arrays.asList(baseDir.listFiles(file -> file.isDirectory()));
		ls.addAll(childs);
		for (File child : childs) {
			ls.addAll(listDir2(child));
		}
		return ls;
	}

}
