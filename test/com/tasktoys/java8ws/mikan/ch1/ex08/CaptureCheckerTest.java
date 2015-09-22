/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */
package com.tasktoys.java8ws.mikan.ch1.ex08;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author mikan
 */
public class CaptureCheckerTest {

    @Test
    public void testSamples() {
        try {
            CaptureChecker.sample1();
            CaptureChecker.sample2();
            CaptureChecker.sample3();
            /*
            [sample1]Peter
            [sample1]Paul
            [sample1]Mary
            [sample2]Peter
            [sample2]Paul
            [sample2]Mary
            [sample3]Peter
            [sample3]Paul
            [sample3]Mary
             */
        } catch (Exception e) {
            fail();
        }
    }
}
