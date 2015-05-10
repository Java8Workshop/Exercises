package com.tasktoys.java8ws.intptr_t.ch3.ex07;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

enum CompareSequence {
	SEQUENTIAL,	// 順序
	REVERSE		// 逆順
}
enum CaseSensitivity{
	CASE_SENSITIVE,		// 大文字小文字区別あり
	CASE_INSENSITIVE	// 大文字区別なし
}
enum WhiteSensitivity {
	SPACE_SENSITIVE,	// 空白を含める
	SPACE_INSENSITIVE	// 空白を除く
}

class StringComparatorBuilder {
	private Function<String, String> lhsFilter;
	private Function<String, String> rhsFilter;
	
	public StringComparatorBuilder(){
		this.lhsFilter = str -> str;
		this.rhsFilter = str -> str;
	}
	
	protected StringComparatorBuilder(Function<String, String> lFilter, Function<String, String> rFilter){
		this.lhsFilter = lFilter;
		this.rhsFilter = rFilter;
	}
	
	public Comparator<String> build() {
		return (s1, s2) -> this.lhsFilter.apply(s1).compareTo(this.rhsFilter.apply(s2));			
	}
	
	public StringComparatorBuilder compose(CompareSequence e) {
		if(e == CompareSequence.REVERSE) {
			// 文字列を逆転する
			Function<String,String> f = str -> new StringBuffer(str).reverse().toString();
			
			return new StringComparatorBuilder(
					this.lhsFilter.compose(f),
					this.rhsFilter.compose(f));
		} else {
			return this;
		}
	}

	public StringComparatorBuilder compose(CaseSensitivity e) {
		if(e == CaseSensitivity.CASE_INSENSITIVE) {
			// 小文字に変換する
			Function<String,String> f = str -> str.toLowerCase();
			
			return new StringComparatorBuilder(
					this.lhsFilter.compose(f),
					this.rhsFilter.compose(f));
		} else {
			return this;
		}
	}
	
	public StringComparatorBuilder compose(WhiteSensitivity e) {
		if(e == WhiteSensitivity.SPACE_INSENSITIVE) {
			// 空白以外の文字列を返す
			Function<String,String> f = str -> str.chars()
					.filter(ch -> !Character.isWhitespace(ch))
					.mapToObj(i -> String.valueOf((char)i))
					.collect(Collectors.joining());
			
			return new StringComparatorBuilder(
					this.lhsFilter.compose(f),
					this.rhsFilter.compose(f));
		} else {
			return this;
		}
	}
}