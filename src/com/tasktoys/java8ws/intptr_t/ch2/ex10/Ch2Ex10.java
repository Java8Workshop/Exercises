package com.tasktoys.java8ws.intptr_t.ch2.ex10;

import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Q: 単純に合計を計算して、count()で割ることができないのはなぜですか。
 * A: 合計を計算した時点で終端操作を実行しているため、count()が実行できないため。
 */
public class Ch2Ex10 {
	public static void main(String[] args) {
		// 1〜10平均値
		OptionalDouble value = average( Stream.iterate(1.0d, d -> d + 1.0d).limit(10) );
		showResult(value);

		// 要素が1つ
		value = average( Stream.of(Double.MAX_VALUE) );
		showResult(value);
		
		// 空要素の平均
		value = average( Stream.empty() );
		showResult(value);		
	}
	
	/**
	 * OptionalDoubleの結果表示
	 * @param value OptionalDouble
	 */
	private static void showResult(OptionalDouble value) {
		if(value.isPresent()) {
			System.out.println(value.getAsDouble());
		} else {
			System.out.println("none");
		}
	}
	
	/**
	 * Doubleストリームから平均値を求める
	 * (DoubleStream#averageを使えば良いなどの野暮な事を行ってはいけない)
	 * @param stream ストリーム
	 * @return
	 */
	static OptionalDouble average(Stream<Double> stream) {
		AverageOperator avgOp = stream.reduce(
				new AverageOperator(),
				(op, e) -> {
					op.add(e);
					return op;
				},
				(op1, op2) -> {
					op1.combine(op2);
					return op1;
				});
		return avgOp.getAverage();
	}	
	
	/**
	 * ストリームで平均を求めるオペレータ
	 */
	static private class AverageOperator{
		private double total;		// 平均算出用の合計
		private long count;			// 平均算出用の要素数
		
		public AverageOperator(){
			this(0.0d, 0);
		}
		
		public AverageOperator(double initialValue,long initialCount) {
			this.total = initialValue;
			this.count = initialCount;
		}
		
		/**
		 * 合計値取得
		 * @return 合計値
		 */
		public double getTotal(){
			return this.total;
		}

		/**
		 * 合計の要素数
		 * @return 要素数
		 */
		public long getCount(){
			return this.count;
		}
		
		/**
		 * 平均値取得
		 * @return 平均値、要素数がない場合empty
		 */
		public OptionalDouble getAverage() {
			return this.count <= 0L ?
					OptionalDouble.empty():
					OptionalDouble.of(getTotal() / getCount());
		}

		/**
		 * 平均要素数追加
		 * @param value 要素値
		 */
		public void add(double value) {
			this.total += value;
			this.count++;
		}

		/**
		 * 平均要素を結合
		 * @param op 結合元
		 */
		public void combine(AverageOperator op) {
			this.total += op.total;
			this.count += op.count;
		}
	}	
}
