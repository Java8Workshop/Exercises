package com.tasktoys.java8ws.lagunapresa.ch9.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreditCardNumberFinder {
	
	private String workDir = "/";
	
	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}

	public List<String> exec() throws IOException {
		try {
			List<String> result = new ArrayList<>();
			ProcessBuilder builder = new ProcessBuilder("grep", "-r",
			// シングルコーテーション不要
					"\\d\\{4\\}\\(-\\d\\{4\\}\\)\\{3\\}", this.workDir);
			Process proc = builder.start();
			proc.waitFor();
			try (BufferedReader r = new BufferedReader(new InputStreamReader(proc.getInputStream()));) {
				for (;;) {
					String line = r.readLine();
					if (line == null)
						break;
					result.add(line);
				}
			}

			return result;

		} catch (InterruptedException e) {
			throw new IOException(e);
		}

	}

}
