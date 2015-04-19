/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/Java8Workshop/Exercises
 */
package com.tasktoys.java8ws.mikan.ch2.ex06;

import java.util.stream.Stream;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author mikan
 */
public class CharacterStreamTest {

    @Test
    public void testAAA() {
        String value = "aiueo";
        Stream<Character> result1 = CharacterStream.characterStream(value);
        Stream<Character> result2 = CharacterStream.characterStream2(value);
        assertNotNull(result1);
        assertNotNull(result2);
        assertArrayEquals(result1.toArray(), result2.toArray());
    }
}
