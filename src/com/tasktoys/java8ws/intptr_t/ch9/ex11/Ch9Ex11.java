package com.tasktoys.java8ws.intptr_t.ch9.ex11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

public class Ch9Ex11 {
	public static void main(String[] args) throws IOException, InterruptedException {
		// サンプルファイルを生成
		String credit = "0123-4567-8901-2345";
		Files.write(Paths.get("./out/credit.txt"),
					credit.getBytes(),
					StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
		// メイン処理
		ProcessBuilder processBuilder = new ProcessBuilder("grep",
				"-r","\\([0-9]\\{4\\}-\\)\\{3\\}[0-9]\\{4\\}",
				System.getProperty("user.home")
				//[列挙が遅くあがってこない場合、本コメントをアンコメントしてディレクトリを限定する] + "/git/"
				);
		processBuilder.inheritIO();
		Process process = processBuilder.start();
		process.waitFor(60L,TimeUnit.SECONDS);
		System.out.println("done.");
	}
}
