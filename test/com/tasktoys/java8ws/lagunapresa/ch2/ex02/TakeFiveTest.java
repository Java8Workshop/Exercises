package com.tasktoys.java8ws.lagunapresa.ch2.ex02;

import com.tasktoys.java8ws.lagunapresa.ch2.ex01.ParStream;
import com.tasktoys.java8ws.util.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

public class TakeFiveTest {

    private static final TakeFive TF = new TakeFive();
    private static final ParStream PS = new ParStream();

    List<String> words;

    private static final Path ALICE = Resource.get("ch2/alice30.txt");

    @Before
    public void setUp() throws Exception {
        words = PS.readAndSplit(ALICE);
        assumeThat(words.size(), is(27343));
    }

    @Test
    public void testTake5WithSideEffect() throws IOException {
        Counter sideEffect = new Counter();
        List<String> longWords = TF.take5WithSideEffect(10, words, sideEffect::accept);
        assertThat(longWords, is(Arrays.asList("conversations", "conversation", "considering", "fortunately", "considering")));
        assertThat(sideEffect.count, is(286));
        assertTrue(sideEffect.count < words.size());
    }

    static class Counter implements IntConsumer {

        int count = 0;

        @Override
        public void accept(int value) {
            count++;
        }

    }

}
