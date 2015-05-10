package com.tasktoys.java8ws.intptr_t.ch3.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class Ch3Ex07 {
	// [テスト用 Predicate]一致
	private static IntPredicate EQ = new IntPredicate() {		
		@Override
		public boolean test(int value) {
			return value == 0;
		}
	};
	// [テスト用 Predicate]未満
	private static IntPredicate LT = new IntPredicate() {		
		@Override
		public boolean test(int value) {
			return value < 0;
		}
	};
	// [テスト用 Predicate]より大きい
	private static IntPredicate GT = new IntPredicate() {		
		@Override
		public boolean test(int value) {
			return value > 0;
		}
	};
	
	public static void main(String[] args) {
		String[][] testcases = new String[][]{
			{"abc", "abc"},		// =
			{"ABC", "abc"},		// <, if ignore case =
			{"abc", "a\nb c"},	// >, if ignore white =
			{"debc", "ebc"},	// <, if reverse >
			{"ABC", "a\nb c"},	// <, if ignore case & ignore white =, if ignore case >
			{"dEBC", "ebc"},	// <, if ignore case & reverse >
			{"da\nb c", "ebc"},	// <, if ignore white & reverse >
			{"dE\nB C", "ebc"}, // <, if ignore case & ignore white & reverse
		};

		//
		// フィルタなしのテスト
		//
		List<Comparator<String>> zeroCmps = Arrays.asList(new StringComparatorBuilder().build());		
		List<List<IntPredicate>> zeroTests = Arrays.asList(
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT)
		);
		System.out.println( test(testcases, zeroCmps, zeroTests) );
		
		// 1つのフィルタありのテスト
		List<Comparator<String>> singleCmps = Arrays.asList(
			// Seq
			new StringComparatorBuilder().compose(CompareSequence.SEQUENTIAL).build(),
			new StringComparatorBuilder().compose(CompareSequence.REVERSE).build(),
			
			// Case
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_INSENSITIVE).build(),			

			// White
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_INSENSITIVE).build()
		);		
		List<List<IntPredicate>> singleTests = Arrays.asList(
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, LT, GT, LT, LT, LT),			
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, LT, LT, LT, LT, LT)
		);
		System.out.println( test(testcases, singleCmps, singleTests) );

		//
		// 2つのフィルタありのテスト
		//
		List<Comparator<String>> doubleCmps = Arrays.asList(
			// Seq -> Case or White
			new StringComparatorBuilder().compose(CompareSequence.SEQUENTIAL).compose(CaseSensitivity.CASE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.SEQUENTIAL).compose(CaseSensitivity.CASE_INSENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.REVERSE).compose(CaseSensitivity.CASE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.REVERSE).compose(CaseSensitivity.CASE_INSENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.SEQUENTIAL).compose(WhiteSensitivity.SPACE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.SEQUENTIAL).compose(WhiteSensitivity.SPACE_INSENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.REVERSE).compose(WhiteSensitivity.SPACE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CompareSequence.REVERSE).compose(WhiteSensitivity.SPACE_INSENSITIVE).build(),

			// Case -> Seq or White
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_SENSITIVE).compose(CompareSequence.SEQUENTIAL).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_SENSITIVE).compose(CompareSequence.REVERSE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_INSENSITIVE).compose(CompareSequence.SEQUENTIAL).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_INSENSITIVE).compose(CompareSequence.REVERSE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_SENSITIVE).compose(WhiteSensitivity.SPACE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_SENSITIVE).compose(WhiteSensitivity.SPACE_INSENSITIVE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_INSENSITIVE).compose(WhiteSensitivity.SPACE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(CaseSensitivity.CASE_INSENSITIVE).compose(WhiteSensitivity.SPACE_INSENSITIVE).build(),

			// White -> Seq or Case
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_SENSITIVE).compose(CompareSequence.SEQUENTIAL).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_SENSITIVE).compose(CompareSequence.REVERSE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_INSENSITIVE).compose(CompareSequence.SEQUENTIAL).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_INSENSITIVE).compose(CompareSequence.REVERSE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_SENSITIVE).compose(CaseSensitivity.CASE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_SENSITIVE).compose(CaseSensitivity.CASE_INSENSITIVE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_INSENSITIVE).compose(CaseSensitivity.CASE_SENSITIVE).build(),
			new StringComparatorBuilder().compose(WhiteSensitivity.SPACE_INSENSITIVE).compose(CaseSensitivity.CASE_INSENSITIVE).build()
		);
		List<List<IntPredicate>> doubleTests = Arrays.asList(
			// Seq -> Case or White
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, LT, GT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, GT, GT, GT, LT, LT),
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, GT, LT, LT, LT, LT),
			
			// Case -> Seq or White
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, LT, GT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, GT, GT, GT, LT, LT),
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, LT, GT, LT, LT, LT),
			Arrays.asList(EQ, EQ, EQ, LT, EQ, LT, LT, LT),

			// White -> Seq or Case
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, GT, LT, LT, LT, LT),
			Arrays.asList(EQ, LT, GT, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, GT, LT, GT, LT, LT, LT),
			Arrays.asList(EQ, LT, EQ, LT, LT, LT, LT, LT),
			Arrays.asList(EQ, EQ, EQ, LT, EQ, LT, LT, LT)
		);
		System.out.println( test(testcases, doubleCmps, doubleTests) );
	}
	
	private static List<Boolean> test(String[][] testcases, List<Comparator<String>> target, List<List<IntPredicate>> test) {
		assert target.size() != 0;
		assert target.size() == test.size();
		assert testcases.length == test.get(0).size();
		
		int[][] ans = target.stream()
				.map(cmp ->
					Arrays.stream(testcases)
						.mapToInt(testcase -> cmp.compare(testcase[0], testcase[1]))
						.toArray()
				).toArray(int[][]::new);
		
		List<Boolean> result = new ArrayList<Boolean>();
		for(int i = 0; i < ans.length; i++) {
			Boolean r = Boolean.TRUE;
			for(int j = 0; j < ans[i].length; j++) {
				if(!test.get(i).get(j).test(ans[i][j])){
					r = Boolean.FALSE;
					break;
				}
			}
			result.add(r);
		}
		return result;
	}
}
