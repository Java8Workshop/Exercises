package com.tasktoys.java8ws.hosoai.ch9.ex01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WithoutTryWithResources {
	public void withoutTryWithResources(String inputFile, String outputFile){
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(inputFile);
			out = new PrintWriter(outputFile);
			while(in.hasNext()){
				out.println(in.next().toLowerCase());
			}
		} catch (IOException e) {
			try{
				if(in!=null){
					in.close();
				}
			}catch(Exception e1){
				System.err.println("Cannnot Close input file");
				throw e1;
			}finally{
				in = null;
			}
			try{
//				if(out!=null){
//					out.close();
//				}
			}catch(Exception e2){
				System.err.println("Cannnot Close output file");
				throw e2;
			}finally{
				out = null;
			}
			return;
		} finally {
			try{
				if(in!=null){
					in.close();
				}
			}catch(Exception e){
				System.err.println("Cannnot Close input file");
				throw e;
			}finally{
				in = null;
			}
			try{
				if(out!=null){
					out.close();
				}
			}catch(Exception e){
				System.err.println("Cannnot Close output file");
				throw e;
			}finally{
				out = null;
			}
		}
	}
	
	public void tryWithResources(String inputFile, String outputFile){
		try(Scanner in = new Scanner(inputFile); PrintWriter out = new PrintWriter(outputFile)){
			while(in.hasNext()){
				out.println(in.next().toLowerCase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
