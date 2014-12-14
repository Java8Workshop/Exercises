package com.tasktoys.java8ws.sato.ch9.ex07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ReadURL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://anond.hatelabo.jp/");
			url.openStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
