package com.tasktoys.java8ws.intptr_t.ch6.ex09;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.LongStream;

public class Matrix {
	private final long[] mat;
	private final int column;
	
	/**
	 * コンストラクタ
	 * @param i 行数
	 * @param j 列数
	 */
	public Matrix(int i, int j) {
		this.mat = new long[i * j];
		this.column = j;
	}
	
	/**
	 * 行数取得
	 * @return 行数
	 */
	public int getRow() {
		return this.mat.length / this.column;
	}
	
	/**
	 * 列数取得
	 * @return 列数
	 */
	public int getColumn() {
		return this.column;
	}
	
	/**
	 * i行j列の要素取得
	 * @param i 行
	 * @param j 列
	 * @return 要素値
	 */
	public long get(int i, int j) {
		int index = i * this.column + j;
		if(index >= this.mat.length) {
			throw new IllegalArgumentException();
		}

		return this.mat[index];
	}
	
	/**
	 * i行j列目に値を設定
	 * @param i 行
	 * @param j 列
	 * @param v 値
	 */
	public void set(int i, int j, long v) {
		int index = i * this.column + j;
		if(index >= this.mat.length) {
			throw new IllegalArgumentException();
		}
		
		this.mat[index] = v;
	}
	
	/**
	 * 行列同士の乗算を計算
	 * @param m 行列の右辺
	 * @return 計算結果
	 */
	public Matrix multiply(Matrix m) {
		Objects.requireNonNull(m);

		if(this.column != m.getRow()){
			throw new IllegalArgumentException();
		}

		Matrix newMat = new Matrix(getRow(), m.column);
		for(int i = 0; i < getRow(); i++) {
			for(int j = 0; j < m.getColumn(); j++) {
				final int ii = i;
				final int jj = j;

				newMat.set(i, j, LongStream.range(0, this.column)
								.reduce(0, (sum, k) -> sum + (get(ii, (int)k) * m.get((int)k, jj))));
			}
		}

		return newMat;
	}
	
	/**
	 * 行列の文字列表現を生成
	 * @return 行列の文字列
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int maxLen = String.valueOf(Arrays.stream(this.mat).parallel().max().getAsLong()).length();
		int minLen = String.valueOf(Arrays.stream(this.mat).parallel().min().getAsLong()).length();
		maxLen = Math.max(maxLen, minLen) + 1;
		
		for(int i = 0; i < getRow(); i++) {
			for(int j = 0; j < getColumn(); j++) {				
				sb.append(String.format("%"+maxLen+"d" , get(i, j)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
