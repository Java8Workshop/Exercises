package com.tasktoys.java8ws.hosoai.ch9.ex03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiExceptionThrow{
	public void process() throws FileNotFoundException, UnknownHostException, IOException{
		try{
			new Socket().connect(new InetSocketAddress(0));
		}catch(FileNotFoundException | UnknownHostException|ConnectException ex){
			throw ex;
		}catch(IOException e){
			throw e;
		}
	}
}
