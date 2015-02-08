package com.tasktoys.java8ws.hosoai.ch9.ex07;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveWebPage {
	Pattern urlRegex = Pattern.compile("(?:http://)?([\\w\\.]+)/(.*)");
	public void save(String url, String outputFile){
		Matcher m = urlRegex.matcher(url);
		if(!m.matches()){
			return;
		}
		String host = m.group(1);
		String file = m.group(2);
		URL u;
		try {
			u = new URL("http", host, file);
			Files.copy(u.openStream(), Paths.get(outputFile));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
