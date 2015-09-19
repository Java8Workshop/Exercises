package com.tasktoys.java8ws.intptr_t.ch8.ex13;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface TestCases {
	TestCase[] value();
}
