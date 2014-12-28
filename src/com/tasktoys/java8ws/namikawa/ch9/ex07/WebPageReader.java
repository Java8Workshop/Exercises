/*
 * Copyright(C) 2014 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/About
 */
package com.tasktoys.java8ws.namikawa.ch9.ex07;

import java.io.IOException;
import java.net.URL;

/**
 *
 * @author takanori
 */
public class WebPageReader {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.yahoo.co.jp/");
        
        System.out.println(url.openStream());
    }
}
