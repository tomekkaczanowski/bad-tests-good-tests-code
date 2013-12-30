package com.practicalunittesting;

public class ReportData {

	private final int min;
	private final int max;
	private final double avg;

	public ReportData(int min, int max, double avg) {
		this.min = min;
		this.max = max;
		this.avg = avg;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public double getAvg() {
		return avg;
	}
}
