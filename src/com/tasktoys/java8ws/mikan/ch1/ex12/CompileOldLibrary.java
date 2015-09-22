/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex12;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class CompileOldLibrary {

    public static void main(String[] args) throws IOException {
        new CompileOldLibrary().compile(
                "src/com/tasktoys/java8ws/mikan/ch1/ex12/oldlib/OldLibraryMain.java7",
                "OldLibraryMain");
    }

    public boolean compile(String path, String className) throws IOException {
        return compile(Paths.get(path), className);
    }

    public boolean compile(Path path, String className) throws IOException {
        Objects.requireNonNull(path);
        Objects.requireNonNull(className);
        String source = Files.readAllLines(path).stream().collect(Collectors.joining());
        Iterable<String> options = Arrays.asList("-d", "build");
        Iterable<JavaFileObject> units = Collections.singletonList(new MyJavaFileObject(className, source));
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        CompilationTask task = ToolProvider.getSystemJavaCompiler().getTask(null, null, diagnostics, options, null, units);
        boolean success = task.call();
        diagnostics.getDiagnostics().forEach(System.out::println); // Fail: source-incompatible
        if (success) {
            try {
                Method method = Class.forName(className).getMethod("main", String[].class);
                method.invoke(null, new Object[]{null});
            } catch (ReflectiveOperationException e) {
                System.err.println(e.getMessage());
            }
        }
        return success;
    }

    private static class MyJavaFileObject extends SimpleJavaFileObject {

        private final String source;

        public MyJavaFileObject(String name, String source) {
            super(URI.create("string:///" + name + Kind.SOURCE.extension),
                    Kind.SOURCE);
            Objects.requireNonNull(name);
            Objects.requireNonNull(source);
            this.source = source;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return source;
        }
    }
}
