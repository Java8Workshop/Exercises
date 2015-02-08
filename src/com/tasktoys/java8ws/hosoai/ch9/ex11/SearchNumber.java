package com.tasktoys.java8ws.hosoai.ch9.ex11;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.MalformedInputException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchNumber {
	Pattern cardNumberPattern = Pattern.compile("\\d{4}(-?\\d{4}){3}+");
	public void search(){
		ProcessBuilder processBuilder = new ProcessBuilder("dir");
		try {
//			processBuilder.inheritIO();
			Path outTemp = Paths.get("out/ex11out.txt");
			Path numbersFile = Paths.get("out/ex11number.txt");
			Path homeDir = Paths.get(System.getProperty("user.home"));
			processBuilder.redirectOutput(outTemp.toFile());
			processBuilder.directory(homeDir.toFile());
			processBuilder.start().waitFor();
			
			List<String> files = Files.readAllLines(outTemp);
			Writer w = Files.newBufferedWriter(numbersFile);
			for(String f : files){
				try{
					Path file = homeDir.resolve(f);
					for(String line : Files.readAllLines(file)){
						Matcher m = cardNumberPattern.matcher(line);
						if(m.matches()){
							w.write(line + " in "+file);
						}
					}
				}catch(Exception e ){
					continue;
				}
			}
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
