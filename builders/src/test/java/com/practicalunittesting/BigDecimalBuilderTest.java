package com.practicalunittesting;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BigDecimalBuilderTest {

	@Test
	public void someTest() {
		List<ProductCategory> categories = Arrays.asList(
				product("car", new BigDecimal("100"), new BigDecimal("10000")),
				product("bike", new BigDecimal("20"), new BigDecimal("5000")),
				product("plane", new BigDecimal("1000"), new BigDecimal("500000"))
		);

		List<ProductCategory> categories2 = Arrays.asList(
				product("car", 100, 10000),
				product("bike", 20, 5000),
				product("plane", 1000, 500000)
		);
	}

	private ProductCategory product(String productCategory, BigDecimal priceFrom, BigDecimal priceTo) {
		return null; // does not matter
	}

	private ProductCategory product(String productCategory, int priceFrom, int priceTo) {
		return product(productCategory, BigDecimal.valueOf(priceFrom), BigDecimal.valueOf(priceTo));
	}

	private class ProductCategory {
		// who cares?
	}
}
