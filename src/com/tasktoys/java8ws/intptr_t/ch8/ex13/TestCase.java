package com.tasktoys.java8ws.intptr_t.ch8.ex13;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(TestCases.class)
@Retention(RetentionPolicy.SOURCE)
public @interface TestCase {
	String params();
	String expected();
}
