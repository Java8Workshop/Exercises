package com.tasktoys.java8ws.intptr_t.ch5.ex07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class Ch5Ex07Test {
	// 現在の日付を固定
	final LocalDate now = LocalDate.now();

	// ベースライン
	final TimeInterval baseTimeline = TimeInterval.of(
			LocalDateTime.of(now, LocalTime.of(10, 0)),
			LocalDateTime.of(now, LocalTime.of(11, 0)));

	// 点を配列
	final TimeInterval[] points = new TimeInterval[]{
		TimeInterval.of(
			LocalDateTime.of(now, LocalTime.of(10, 0)),
			LocalDateTime.of(now, LocalTime.of(10, 0))),
		TimeInterval.of(
			LocalDateTime.of(now, LocalTime.of(10, 30)),
			LocalDateTime.of(now, LocalTime.of(10, 30))),
		TimeInterval.of(
			LocalDateTime.of(now, LocalTime.of(11, 0)),
			LocalDateTime.of(now, LocalTime.of(11, 0))),
	};

	/**
	 * 時刻ベースライン前の試験
	 */
	@Test
	public void testOutOfTimelineBefore() {
		TimeInterval case1 = TimeInterval.of(
				LocalDateTime.of(now, LocalTime.of(9, 0)),
				LocalDateTime.of(now, LocalTime.of(9, 59)));

		assertThat(TimeInterval.intersectWith(baseTimeline, case1), is(false));
		assertThat(TimeInterval.intersectWith(case1, baseTimeline), is(false));
	}
	
	/**
	 * 時刻ベースラインの始端重なり試験
	 */
	@Test
	public void testCrossTimelineBegin() {
		TimeInterval case2 = TimeInterval.of(
				LocalDateTime.of(now, LocalTime.of(9, 0)),
				LocalDateTime.of(now, LocalTime.of(10, 1)));

		assertThat(TimeInterval.intersectWith(baseTimeline, case2), is(true));
		assertThat(TimeInterval.intersectWith(case2, baseTimeline), is(true));
	}

	/**
	 * 時刻ベースライン終端重なり試験
	 */
	@Test
	public void testCrossTimelineEnd() {
		TimeInterval case3 = TimeInterval.of(
				LocalDateTime.of(now, LocalTime.of(9, 0)),
				LocalDateTime.of(now, LocalTime.of(10, 1)));

		assertThat(TimeInterval.intersectWith(baseTimeline, case3), is(true));
		assertThat(TimeInterval.intersectWith(case3, baseTimeline), is(true));
	}

	/**
	 * 時刻ベースライン後試験
	 */
	@Test
	public void testOutOfTimelineAfter() {
		TimeInterval case4 = TimeInterval.of(
				LocalDateTime.of(now, LocalTime.of(11, 1)),
				LocalDateTime.of(now, LocalTime.of(12, 0)));

		assertThat(TimeInterval.intersectWith(baseTimeline, case4), is(false));
		assertThat(TimeInterval.intersectWith(case4, baseTimeline), is(false));
	}
	
	/**
	 * 時刻ベースライン内試験
	 */
	@Test
	public void testInOfTimeline() {
		TimeInterval case5 = TimeInterval.of(
				LocalDateTime.of(now, LocalTime.of(10, 1)),
				LocalDateTime.of(now, LocalTime.of(10, 59)));
		
		assertThat(TimeInterval.intersectWith(baseTimeline, case5), is(true));
		assertThat(TimeInterval.intersectWith(case5, baseTimeline), is(true));
	}
	
	/**
	 * 時刻ベースラインと同じ時刻ベースライン試験
	 */
	@Test
	public void testSameTimeline() {
		assertThat(TimeInterval.intersectWith(baseTimeline, baseTimeline), is(true));
	}

	/**
	 * 始端、終端同一点とベースライン試験
	 */
	@Test
	public void testTimelinePoint() {
		for(TimeInterval point: points) {
			assertThat(TimeInterval.intersectWith(baseTimeline, point), is(true));			
			assertThat(TimeInterval.intersectWith(point, baseTimeline), is(true));			
		}
	}

	/**
	 * 時点と時点の試験
	 */
	@Test
	public void testPointPoint() {
		assertThat(TimeInterval.intersectWith(points[0], points[0]), is(true));
		assertThat(TimeInterval.intersectWith(points[0], points[1]), is(false));
		assertThat(TimeInterval.intersectWith(points[0], points[2]), is(false));
	}
	
	/**
	 * 日付がベースライン前試験
	 */
	@Test
	public void testOutOfDaysBefore() {
		TimeInterval outBefore = TimeInterval.of(
				LocalDateTime.of(now.minusDays(1), LocalTime.of(10, 1)),
				LocalDateTime.of(now.minusDays(1), LocalTime.of(10, 59)));

		assertThat(TimeInterval.intersectWith(outBefore, baseTimeline), is(false));
		assertThat(TimeInterval.intersectWith(baseTimeline, outBefore), is(false));
	}
	
	/**
	 * 日付がベースライン後試験
	 */
	@Test
	public void testOutOfDaysAfter() {
		TimeInterval outAfter = TimeInterval.of(
				LocalDateTime.of(now.plusDays(1), LocalTime.of(10, 1)),
				LocalDateTime.of(now.plusDays(1), LocalTime.of(10, 59)));
		
		assertThat(TimeInterval.intersectWith(outAfter, baseTimeline), is(false));
		assertThat(TimeInterval.intersectWith(baseTimeline, outAfter), is(false));
	}

	/**
	 * 日付がベースラインと重なる試験
	 */
	@Test
	public void testCrossDays() {
		TimeInterval crossDays = TimeInterval.of(
				LocalDateTime.of(now.minusDays(1), LocalTime.of(10, 1)),
				LocalDateTime.of(now.plusDays(1), LocalTime.of(10, 59)));
		
		assertThat(TimeInterval.intersectWith(crossDays, baseTimeline), is(true));
		assertThat(TimeInterval.intersectWith(baseTimeline, crossDays), is(true));
	}
}
