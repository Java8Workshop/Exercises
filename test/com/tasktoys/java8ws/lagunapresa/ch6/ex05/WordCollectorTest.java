package com.tasktoys.java8ws.lagunapresa.ch6.ex05;

import com.tasktoys.java8ws.util.Resource;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordCollectorTest {

    @Test
    public void testCollect() throws Exception {
        Map<String, Set<File>> map = WordCollector.collect(Arrays.asList(
            Resource.get("ch6/AbstractAction.txt"),
            Resource.get("ch6/AbstractBorder.txt")
        ));
        assertThat(map.size(), is(475));
        System.out.println(map);
    }

}