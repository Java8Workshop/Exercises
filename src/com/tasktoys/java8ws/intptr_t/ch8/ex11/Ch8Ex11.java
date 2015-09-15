package com.tasktoys.java8ws.intptr_t.ch8.ex11;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class Ch8Ex11 {
	public static void main(String[] args) throws IOException {		
		URL url = new URL("http://htaccess.cman.jp/sample_go/basic/"); // ググって１番はじめにきたサイトから拝借
		
		URLConnection connection = url.openConnection();
		Encoder encoder = Base64.getEncoder();
		String userpass = "guest:password";
		String auth = "Basic " + new String(encoder.encode(userpass.getBytes()));
		connection.setRequestProperty("Authorization", auth);
		
		connection.connect();
		try(Scanner scanner = new Scanner(connection.getInputStream())){
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}
}
