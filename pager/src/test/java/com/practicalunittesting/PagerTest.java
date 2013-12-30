package com.practicalunittesting;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class PagerTest {

	private static final int PER_PAGE = 10;

	public void shouldGiveOffsetZeroWhenOnZeroPage() {
		Pager pager = new Pager(PER_PAGE);

		assertThat(pager.getOffset()).isEqualTo(0);
	}

	public void shouldIncreaseOffsetWhenGoingToPageOne() {
		Pager pager = new Pager(PER_PAGE);

		pager.goToNextPage();

		assertThat(pager.getOffset()).isEqualTo(PER_PAGE);
	}

	public void shouldIncreaseOffsetWhenGoingToPageTwo() {
		Pager pager = new Pager(PER_PAGE);

		pager.goToNextPage();
		pager.goToNextPage();

		assertThat(pager.getOffset()).isEqualTo(2 * PER_PAGE);
	}
}
