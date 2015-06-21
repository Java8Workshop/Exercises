package com.tasktoys.java8ws.intptr_t.ch4.ex02;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * プロパティを持つクラス。
 * 
 * JavaFX設計者曰く、プロパティのゲッターとセッターをfinalと宣言する事を推奨しているらしい。
 * @see Ch4Ex02Test
 */
public class Ch4Ex02 {
	private SimpleIntegerProperty prop = null;	// 初期状態はnull

	/**
	 * 練習問題2の回答
	 */
	public final SimpleIntegerProperty valueProperty() {
		// はじめてxxxPropertyメソッドが呼ばれたときにプロパティオブジェクトを構築する
		if( this.prop == null) {
			this.prop = new SimpleIntegerProperty();
		}
		return this.prop;
	}

	public final int getValue() {
		// 通常intのデフォルト(0)を返すべきだが、
		// 題意確認(プロパティ未初期化である事を確認)できるようにするため-1を返却する
		return (this.prop == null) ? -1 : this.prop.get();
	}
	
	/**
	 * 練習問題3の回答
	 */
	public final void setValue(int value) {
		valueProperty().set(value);
	}
}
