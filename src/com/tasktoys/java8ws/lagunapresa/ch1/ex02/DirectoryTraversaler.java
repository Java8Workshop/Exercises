package com.tasktoys.java8ws.lagunapresa.ch1.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DirectoryTraversaler {

	public List<File> listDir(File root) {
		if (root.isDirectory()) {
			List<File> ls = new ArrayList<>();
			List<File> childs = Arrays.asList(root.listFiles(File::isDirectory));
			ls.addAll(childs);
			for (File child : childs) {
				ls.addAll(listDir(child));
			}
			return ls;
		} else {
			return Collections.emptyList();
		}
	}

	// メソッド参照じゃないほう
	public List<File> listDir2(File root) {
		if (root.isDirectory()) {
			List<File> ls = new ArrayList<>();
			List<File> childs = Arrays.asList(root.listFiles(file -> file.isDirectory()));
			ls.addAll(childs);
			for (File child : childs) {
				ls.addAll(listDir2(child));
			}
			return ls;
		} else {
			return Collections.emptyList();
		}
	}

}
