package com.tasktoys.java8ws.lagunapresa.ch9.ex11;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

// on Mac
public class CreditCardNumberFinderTest {

	@Test
	public void test() throws IOException {
		CreditCardNumberFinder finder = new CreditCardNumberFinder();
		finder.setWorkDir("/Users/LagunaPresa/ex11/");
		List<String> result = finder.exec();
		assertThat(result, is(Arrays.asList("/Users/LagunaPresa/ex11//dir/ex03:6666-7777-8888-9999",
				"/Users/LagunaPresa/ex11//ex01:6666-7777-8888-9999",
				"/Users/LagunaPresa/ex11//ex02:0000-0000-0000-0002")));
	}

}
