package com.tasktoys.java8ws.intptr_t.ch1.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ch1Ex02 {
	public static void main(String[] args) {
		File file = new File("./");
		ArrayList<File> subdirs1, subdirs2;
		
		subdirs1 = new ArrayList<File>();
		subdirs2 = new ArrayList<File>();
		
		// lambda version
		System.out.println("lambda:");
		enumDirsWithLambda( subdirs1,file.listFiles(name->name.isDirectory()) );
		subdirs1.stream().forEach(System.out::println);

		// method reference
		System.out.println("method reference:");
		enumDirsWithMehodReference( subdirs2,file.listFiles(File::isDirectory) );
		subdirs2.stream().forEach(System.out::println);
		
		// check matching all
		boolean match = true;
		for( File dir1 : subdirs1 ) {
			match &= subdirs2.contains(dir1);
			if(!match){ break; }
		}
		System.out.println("match?: " + match);
	}	
	
	static void enumDirsWithLambda( List<File> list, File[] dirs ){
		for( File dir : dirs ) {
			list.add(dir);
			enumDirsWithLambda(list,dir.listFiles(name->name.isDirectory()));
		}
	}

	static void enumDirsWithMehodReference( List<File> list, File[] dirs ) {
		for( File dir : dirs ) {
			list.add(dir);
			enumDirsWithMehodReference(list,dir.listFiles(File::isDirectory));
		}		
	}
}
