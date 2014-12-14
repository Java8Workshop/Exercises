package com.tasktoys.java8ws.lagunapresa.ch9.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class WebPageScraper {

	public static void main(String[] args) throws IOException {
		try (InputStream is = new URL("https://github.com/Java8Workshop/Exercises/blob/master/README.md").openStream()) {
			Files.copy(is, Paths.get("out/out.html"), StandardCopyOption.REPLACE_EXISTING);
		}
	}

}
