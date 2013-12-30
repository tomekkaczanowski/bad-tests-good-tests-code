package com.practicalunittesting;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SimpleTypeTest {

    List<ProductCategory> categories = Arrays.asList(
            product("car", new BigDecimal("100"), new BigDecimal("10000")),
            product("bike", new BigDecimal("20"), new BigDecimal("5000")),
            product("plane", new BigDecimal("1000"), new BigDecimal("500000"))
    );

    private ProductCategory product(String name, BigDecimal discount, BigDecimal price) {
        return null;
    }

    List<ProductCategory> categories2 = Arrays.asList(
            product("car", 100, 10000),
            product("bike", 20, 5000),
            product("plane", 1000, 500000)
    );

    private ProductCategory product(String name, int discount, int price) {
        return product(name, new BigDecimal(discount), new BigDecimal(price));
    }

}
