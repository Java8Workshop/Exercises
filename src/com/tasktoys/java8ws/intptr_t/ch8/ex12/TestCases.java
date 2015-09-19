package com.tasktoys.java8ws.intptr_t.ch8.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestCases {
	TestCase[] value();
}
