package com.tasktoys.java8ws.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Resource {

    public static Path get(String path) {
        return Paths.get("test", "res").resolve(path);
    }

}
