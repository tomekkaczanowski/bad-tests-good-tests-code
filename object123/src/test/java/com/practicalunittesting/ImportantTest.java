package com.practicalunittesting;

import org.testng.annotations.Test;

public class ImportantTest {

	private DaoTestHelper daoTestHelper;
	private Product product;

	@Test
	public void importantTest() {
		User user1 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(user1, "PL", 1);
		daoTestHelper.userProduct30DayStatistics(user1, "US", 2);
		User user2 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(user2, "PL", 4);
		daoTestHelper.userProduct30DayStatistics(user2, "US", 8);

		// ... and so on till user5 or so
	}

	@Test
	public void renamedTest() {
		User userWith1PlEntry = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(userWith1PlEntry, "PL", 1);
		daoTestHelper.userProduct30DayStatistics(userWith1PlEntry, "US", 2);
		User userWith4PlEntries = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(userWith4PlEntries, "PL", 4);
		daoTestHelper.userProduct30DayStatistics(userWith4PlEntries, "US", 8);
	}

	@Test
	public void longTest() {
		User user1 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(user1, "PL", 1);
		daoTestHelper.userProduct30DayStatistics(user1, "US", 2);
		User user2 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(user2, "PL", 4);
		daoTestHelper.userProduct30DayStatistics(user2, "US", 8);
		User user3 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.DELETED);
		daoTestHelper.userProduct30DayStatistics(user3, "PL", 16);
		daoTestHelper.userProduct30DayStatistics(user3, "CZ", 32);
		User user4 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.ACTIVE);
		daoTestHelper.userProduct30DayStatistics(user3, "US", 64);
		User user5 = daoTestHelper.addUserAndAssociateWithProduct(
				product, 30l, ProductUserState.DELETED);
	}
}
