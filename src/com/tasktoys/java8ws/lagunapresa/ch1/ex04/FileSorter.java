package com.tasktoys.java8ws.lagunapresa.ch1.ex04;

import java.io.File;
import java.util.Arrays;

public class FileSorter {

	public File[] sort(File[] files) {
		File[] result = files.clone();
		Arrays.sort(result, (f1, f2) -> {
			boolean f1d = f1.isDirectory();
			boolean f2d = f2.isDirectory();
			if (f1d ^ f2d) {
				return f1d ? -1 : 1;
			} else {
				return f1.getPath().compareTo(f2.getPath());
			}
		});
		return result;
	}

}
