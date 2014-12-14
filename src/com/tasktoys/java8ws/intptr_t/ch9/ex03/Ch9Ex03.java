package com.tasktoys.java8ws.intptr_t.ch9.ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ch9Ex03 {
	private static final Logger logger = Logger.getLogger(Ch9Ex03.class.getSimpleName());

	public static void main(String[] args) {
		
		try {
			new Ch9Ex03().process();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
		}
	}
	
	public void process() throws FileNotFoundException,UnknownHostException {
		try {
			int a = 0;
			if( a == 0 ) {
				throw new FileNotFoundException();
			} else {
				throw new UnknownHostException();
			}
		} catch(FileNotFoundException | 
				UnknownHostException ex) {
			logger.log(Level.SEVERE, " ... ", ex);
			throw ex;
		}
	}
}
