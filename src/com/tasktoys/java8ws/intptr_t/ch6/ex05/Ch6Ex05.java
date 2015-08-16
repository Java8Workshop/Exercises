package com.tasktoys.java8ws.intptr_t.ch6.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;

class Pair<T, U> {
	final T item1;
	final U item2;
	
	private Pair(T t, U u) {
		this.item1 = t;
		this.item2 = u;
	}
	
	public static<T, U> Pair<T, U> of(T t, U u) {
		return new Pair<>(t, u);
	}
}

public class Ch6Ex05 {
	public static void main(String[] args) throws IOException {
		final Path pathA = Paths.get("./out/a.txt");
		final Path pathB = Paths.get("./out/b.txt");
		
		//===================
		// テスト用ファイル生成
		//===================
		final String a = "a b c";
		final String b = "b c d";
		Files.write(pathA , a.getBytes(), StandardOpenOption.CREATE);
		Files.write(pathB, b.getBytes(), StandardOpenOption.CREATE);		
		
		//===================
		// 練習問題用コード実行
		//===================
		Pair<ConcurrentHashMap<String, Set<File>>, ConcurrentHashMap<File, Throwable>> r =
				makeWordAndFileRelation(pathA.toFile(), pathB.toFile());
		Map<String, Set<File>> wordsMap = r.item1;
		Map<File, Throwable> excepts = r.item2;

		//===================
		// 実行結果表示
		//===================		
		// 例外が発生している場合、発生している例外を表示
		if(!excepts.isEmpty()) {
			System.out.println(excepts);
		}
		
		// 検算、インスタンスが変わるように毎回Path#getする。また、文字列で一致しないようカレント("./")を外しておく
		final Map<String, List<Path>> ans = new HashMap<>();
		ans.put("a", Arrays.asList(Paths.get("out/a.txt")));
		ans.put("b", Arrays.asList(Paths.get("out/a.txt"), Paths.get("out/b.txt")));
		ans.put("c", Arrays.asList(Paths.get("out/a.txt"), Paths.get("out/b.txt")));
		ans.put("d", Arrays.asList(Paths.get("out/b.txt")));
		BiPredicate<File, Path> isSameFile = (f, p) -> {	// ファイルfとパスpが同一ファイルをさしているかチェック
			try {
				return Files.isSameFile(f.toPath(), p);
			} catch(IOException | SecurityException e) { // 題意と関係ないエラーは考えないことにする。。。
				return false;
			}
		};
		BiPredicate<Set<File>, Path> hasPath = (ff, p) -> {	// 集合ff内に、pが含まれるかチェック
			return ff.stream().anyMatch(f -> isSameFile.test(f, p));
		};
		
		ans.forEach((k, v) -> {
			Set<File> fileSet = wordsMap.get(k);

			// 全てのテスト要パスvの要素が、fileSetに存在するかチェック
			if(v.stream().allMatch(path -> hasPath.test(fileSet, path))){
				System.out.println(k + ":OK");
			} else {
				System.out.println(k + ":NG");
			}
		});
		System.out.println(wordsMap);
	}

	/**
	 * 引数で渡したファイルの各単語が、どのファイルで使用されているかを返す
	 * @param files ファイル一覧
	 * @return
	 */
	public static Pair<ConcurrentHashMap<String ,Set<File>>,
				ConcurrentHashMap<File, Throwable>>
			makeWordAndFileRelation(File... files)
	{
		ConcurrentHashMap<String, Set<File>> wordsMap = new ConcurrentHashMap<>();
		ConcurrentHashMap<File, Throwable> excepts = new ConcurrentHashMap<>();
		
		Arrays.stream(files).parallel().forEach(file -> {
			try {
				String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
				String[] words = contents.split("[\\P{L}]+");
				
				// 全ての文字に対して操作
				Arrays.stream(words).parallel().forEach(w -> {
					// 別スレッドで実行されているか確認要コード(*1)
					// System.out.println("thread:" + Thread.currentThread().getId());	// *1
					
					wordsMap.merge(w, new HashSet<>(Arrays.asList(file)), (oldValue, newValue) -> {
						// 元のセットに、新規で作成したセットをマージ
						// ConcurrentHashMapでスレッドセーフだから、そのまま追加。
						oldValue.addAll(newValue);

						// ブロック時間を短くするため即リターン
						return oldValue;
					});
				});
			} catch (Throwable th) {
				// 例外は特に処理せず溜め込む
				excepts.put(file, th);
			}
		});
		
		return Pair.of(wordsMap, excepts);
	}
}
