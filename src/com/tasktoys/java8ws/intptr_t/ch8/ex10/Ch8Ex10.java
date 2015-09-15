package com.tasktoys.java8ws.intptr_t.ch8.ex10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Ch8Ex10 {
	public static void main(String[] args) throws IOException {
		// インストールJDKのパスからsrc.zipのパスを生成する
		Path baseDir = Paths.get(System.getProperty("java.home"));
		Path srcZip = baseDir.resolveSibling("src.zip");
		
		// src.zipを展開
		unzip(srcZip, Paths.get("./out"));
		
		// 展開ファイルを走査
		Files.walk(Paths.get("./out/src"))
			.filter(FindWords.of("transient", "volatile"))
			.forEach(System.out::println);
	}
	
	/**
	 * 指定した単語存在するかをチェックする述語
	 */
	static class FindWords implements Predicate<Path> {
		private final List<String> checkWordList;
		
		@Override
		public boolean test(Path path) {
			// ファイル以外は対象外
			if(!path.toFile().isFile()) {
				return false;
			}
			
			String contents;
			try {
				contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			
			return words.parallelStream().anyMatch(checkWordList::contains);
		}
		
		public static FindWords of(String ...words){
			return new FindWords(words);
		}
		
		private FindWords(String ...words) {
			this.checkWordList = Arrays.asList(words);
		}
	};

	/**
	 * zipファイルを展開する
	 * @param zipPath 展開元zipファイル
	 * @param extractPath 展開先ディレクトリパス
	 * @return 正否。true: 成功、false: 失敗
	 */
	static boolean unzip(Path zipPath, Path extractPath) {
		try (ZipFile zipFile = new ZipFile(zipPath.toAbsolutePath().toFile())){
			Enumeration<? extends ZipEntry> enumZip = zipFile.entries();
			while(enumZip.hasMoreElements()) {
				ZipEntry zipEntry = enumZip.nextElement();				
				
				// <展開先絶対パス>/<元zipの拡張子無し>/<zipファイル内のファイル名>
				Path outPath = Paths.get(extractPath.toAbsolutePath().toString(),
						 				 GetFileNameWithoutExtension(zipPath.getFileName().toString()),
						 				 zipEntry.getName());
				File outFile = outPath.toFile();
				
				if(zipEntry.isDirectory()) {
					outFile.mkdir();
				} else {
					// 展開ファイルを格納するディレクトリが存在しない場合、ディレクトリを生成
					if(!outFile.getParentFile().exists()) {
						if(!outFile.getParentFile().mkdirs()){
							return false;
						}
					}
					
					try(BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(zipEntry));
						BufferedOutputStream ois = new BufferedOutputStream(new FileOutputStream(outFile)))
					{
						byte[] buffer = new byte[1024];
						int readSize = -1;
						while((readSize = bis.read(buffer)) != -1) {
							ois.write(buffer, 0, readSize);
						}
					}catch(Exception ex) {
						return false;
					}
				}
			}
		} catch(Exception ex) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 拡張子を除いたファイル名を取得
	 * @param filename ファイル名
	 * @return 拡張子を除いたファイル名
	 */
	static String GetFileNameWithoutExtension(String filename) {
		int path = filename.lastIndexOf("/");
		if(path < 0){
			path = Math.max(path, filename.lastIndexOf("\\"));
		}
		int index = filename.lastIndexOf(".");
		if(path < 0) { // パス区切りが無い
			if(index > 0) {
				return filename.substring(0, index);
			}
		} else { // パス区切りあり
			if(index > 0 && index > path) {
				return filename.substring(0, index);
			}
		}
		return filename;
	}
}
