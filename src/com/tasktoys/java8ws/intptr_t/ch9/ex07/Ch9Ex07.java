package com.tasktoys.java8ws.intptr_t.ch9.ex07;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Ch9Ex07 {
	public static void main(String[] args) throws IOException {
		String filePath = new File(".").getAbsolutePath() + "/README.md";
		URL url = new URL( "file://" + filePath );
		try( InputStream istream = url.openStream() ) {
			Files.copy(istream, Paths.get("./out/intptr_t-09-07.txt"), StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
