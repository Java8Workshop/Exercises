package com.tasktoys.java8ws.sato.ch1.ex02;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		File file = new File("./");
		File[] files = file.listFiles((f, str) -> true);
		print(files);
		print(file.listFiles(Main::filter));
		
		System.out.println("\n get all");
		print(getAllSubDirectory(file));
	}
	
	public static boolean filter(File file, String str) {
		return true;
	}
	
	public static List<File> getSubDirectory(File file) {
		List<File> ls = new LinkedList<>();
		if (file.isDirectory()) {
			File[] files = file.listFiles((f, str) -> true);
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) ls.add(files[i]);
			}
		}
		return ls;
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