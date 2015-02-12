package com.tasktoys.java8ws.sato.ch1.ex02;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		File file = new File("./");
		File[] files = file.listFiles(f -> true);
		print(files);
		print(file.listFiles(Main::filter));
		
		System.out.println("\n get all");
		print(getAllSubDirectory(file));
	}
	
	public static boolean filter(File file) {
		return true;
	}
	
	public static List<File> getSubDirectory(File file) {
		if (file.isDirectory())
			return Stream.of(file.listFiles(f -> f.isDirectory())).collect(Collectors.toList());
		return new LinkedList<File>();
	}
	
	public static List<File> getAllSubDirectory(File file) {
		List<File> ls = new LinkedList<>();
		if (file.isDirectory()) {
			List<File> files = getSubDirectory(file);
			ls.addAll(files);
			for (File f: files) {
				ls.addAll(getAllSubDirectory(f));
			}
		}
		return ls;
	}
	
	public static void print(File[] files) {
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
	}

	public static void print(List<File> files) {
		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i).getName());
		}
	}
}