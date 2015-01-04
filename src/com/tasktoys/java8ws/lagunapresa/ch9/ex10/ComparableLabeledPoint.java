package com.tasktoys.java8ws.lagunapresa.ch9.ex10;

import com.tasktoys.java8ws.lagunapresa.ch9.ex09.LabeledPoint;

public class ComparableLabeledPoint extends LabeledPoint implements Comparable<ComparableLabeledPoint> {

	public ComparableLabeledPoint(String label, int x, int y) {
		super(label, x, y);
	}

	@Override
	public int compareTo(ComparableLabeledPoint o) {
		int labelDiff = label.compareTo(o.label);
		if (labelDiff != 0)
			return labelDiff;
		int xDiff = Integer.compare(x, o.x);
		if (xDiff != 0)
			return xDiff;
		return Integer.compare(y, o.y);
	}

}
