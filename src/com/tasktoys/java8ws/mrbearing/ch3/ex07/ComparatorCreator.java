package com.tasktoys.java8ws.mrbearing.ch3.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorCreator {

	/**
	 * 通常比較
	 *
	 * @return
	 */
	public static Comparator<String> comparingOrderedComparator() {
		return (o1, o2) -> o1.compareTo(o2);
	}

	public static Comparator<String> comparingOrderedReversedComparator() {
		return (o1, o2) -> o1.compareTo(o2);
	}

	public static Comparator<String> comparingIgnoreCaseComparator() {
		return (o1, o2) -> o1.compareToIgnoreCase(o2);
	}

	public static Comparator<String> comparingIgnoreSpace() {
		return (o1, o2) -> {
			String o1NoSpace = o1.replaceAll(" ", "");
			String o2NoSpace = o2.replaceAll(" ", "");
			return o1NoSpace.compareTo(o2NoSpace);
		};
	}

	public static void main(String[] args) {
		ArrayList<String> testlist = new ArrayList<>();

		testlist.addAll(Arrays.asList("mB LsbYrtB", "X SWrSWGUR", "umguWnHreb",
				"nMQGhtSFbb", "WGVZnwGMim", "YQezgNjpsp", "dVjxUSRFWR",
				"VNnQpJEAYM", "L wDZNmUdU", "jVJFLerBpZ", "nEJPKNxjKh",
				"ZK  NEZCnr", "AWmKCYjHTm", "LhmwAAsiKd", "nsQCACYuwp",
				"TYEWjfgMcV", "RbnbaReaNe", "WuKKtSWAnd", "rJ bGanLpS",
				"sJbrTUNyYW"));

		List<String> clList = extracted(testlist);

		Collections.sort(clList, comparingOrderedComparator());
		System.out.println("");
		System.out.println("#####orderd####");
		clList.forEach(System.out::println);

		System.out.println("");
		System.out.println("#####reverse####");
		Collections.sort(clList, comparingOrderedComparator().reversed());
		clList.forEach(System.out::println);

		System.out.println("");
		System.out.println("#####ignore space####");
		Collections.sort(clList, comparingIgnoreSpace());
		clList.forEach(System.out::println);

	}

	@SuppressWarnings("unchecked")
	private static List<String> extracted(ArrayList<String> testlist) {
		return (List<String>) testlist.clone();
	}
}
