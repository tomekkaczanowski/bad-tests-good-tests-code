package com.practicalunittesting;

import java.math.BigDecimal;

public class Pager {
	private final int perPage;
	private int offset;

	public Pager(int perPage) {
		this.perPage = perPage;
		this.offset = 0;
	}

	public void goToNextPage() {
		this.offset = +perPage;
	}

	public int getOffset() {
		return offset;
	}
}
