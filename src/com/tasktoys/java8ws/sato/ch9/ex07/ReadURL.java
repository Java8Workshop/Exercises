package com.tasktoys.java8ws.sato.ch9.ex07;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ReadURL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://anond.hatelabo.jp/20141214222840");
			Files.copy(url.openStream(), Paths.get("./out/anond.txt"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
