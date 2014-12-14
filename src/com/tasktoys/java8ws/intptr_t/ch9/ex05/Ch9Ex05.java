package com.tasktoys.java8ws.intptr_t.ch9.ex05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ch9Ex05 {

	public static void main(String[] args) {
		Path home = Paths.get("").toAbsolutePath();
		
		System.out.println(home);
		System.out.println(home.resolve("../"));
		System.out.println(home.resolve("/Users"));
	}
}
