package com.tasktoys.java8ws.intptr_t.ch6.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import javax.swing.text.MutableAttributeSet;

public class Ch6Ex10 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://github.com/Java8Workshop");

		CompletableFuture<String> contents = readPage(url);
		CompletableFuture<List<URL>> links = contents.thenApply(Ch6Ex10::getLinks);
		links.thenAccept(list -> {
			list.forEach(System.out::println);
		});

		ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
	}
	
	/**
	 * Webページのテキストから アンカー要素(A)のリンク属性を取得
	 * @param page Webページのテキスト
	 * @return ページ内のリンク一覧
	 */
	public static List<URL> getLinks(String page) {
		ArrayList<URL> retVal = new ArrayList<>();

		try (StringReader sr = new StringReader(page)){
			new ParserDelegator().parse(sr, new HTMLEditorKit.ParserCallback(){					
				@Override
				public void handleStartTag(HTML.Tag tag, MutableAttributeSet attrs, int pos) {
					if(tag == HTML.Tag.A) {
						try {
							Object href = attrs.getAttribute(HTML.Attribute.HREF);
							retVal.add(new URL(href.toString()));
						} catch (MalformedURLException e) {
							// 無効なURLは無視する
							//throw new RuntimeException(e);							
						}
					}
				}
			}, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return retVal;
	}
	
	/**
	 * 非同期でWebページからHTMLテキスト取得
	 * @param url URL
	 * @return　ページテキストのFuture
	 */
	public static CompletableFuture<String> readPage(URL url) {		
		return CompletableFuture.supplyAsync(() -> blockingReadPage(url));
	}
	
	/**
	 * WebページからHTMLテキスト取得
	 * @param url　URL
	 * @return ページテキスト
	 */
	public static String blockingReadPage(URL url) {
		try (InputStream istream = url.openStream()){
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(istream));
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
