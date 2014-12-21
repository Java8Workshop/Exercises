package com.tasktoys.java8ws.mrbearing.ch9.ex07;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class WebPageReader {

  public static void main(String[] args) throws IOException {
    Path out = Paths.get("./out/webPageReadResult.txt");
    URL url = new URL(args[0]);

    /*
     * アトミック性を失わせるため除去 if(Files.notExists(out,LinkOption.NOFOLLOW_LINKS))
     * Files.createFile(out);
     */

    Files.copy(url.openStream(), out, StandardCopyOption.REPLACE_EXISTING);

  }

}
