/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch8.ex12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author mikan
 */
public class TestCaseLoader {

    public static void main(String[] args) throws ReflectiveOperationException {
        Class<?> cls = Class.forName("local.js8ri.ch08.ex12.SampleTestCase");
        Object obj = cls.newInstance();
        int count = 0;
        for (Method m : cls.getMethods()) {
            for (Annotation a : m.getAnnotations()) {
                if (a.annotationType() == TestCase.class) {
                    count++;
                    System.out.println(m.getName() + " method: " + m.invoke(obj, 1));
                }
            }
        }
        System.out.println("Invoked " + count + " method(s).");
    }
}
