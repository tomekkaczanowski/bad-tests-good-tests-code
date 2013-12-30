package com.practicalunittesting;

public interface DaoTestHelper {
	User addUserAndAssociateWithProduct(Product product, long whatever, ProductUserState state);

	void userProduct30DayStatistics(User user, String language, int whatever);
}
