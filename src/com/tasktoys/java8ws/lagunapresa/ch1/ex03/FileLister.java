package com.tasktoys.java8ws.lagunapresa.ch1.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileLister {

	public List<String> filesIn(File root, String ext) {
		return Arrays.asList(root.list((a, b) -> b.endsWith(ext)));
	}

}
