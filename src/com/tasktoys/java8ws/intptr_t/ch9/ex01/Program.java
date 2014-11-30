package com.tasktoys.java8ws.intptr_t.ch9.ex01;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Javaプログラマーなら習得しておきたい Java SE 8 実践プログラム
 * 第9章 練習問題1
 * @author intptr_t
 */
public class Program {
	public static void main(String[] args) throws Exception {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get("/usr/share/dict/words"));
			out = new PrintWriter("/tmp/out.txt");

			while(in.hasNext()) {
				out.println(in.next().toLowerCase());
			}			
		} finally {
			try {
				if (in != null) { in.close(); }
			} finally {
				if (out != null){ out.close(); }				
			}
		}
	}
}
