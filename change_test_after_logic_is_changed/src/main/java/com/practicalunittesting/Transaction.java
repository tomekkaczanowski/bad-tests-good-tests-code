package com.practicalunittesting;

import java.math.BigDecimal;

public class Transaction {

    private final BigDecimal amount;
    private final User user;

    public Transaction(BigDecimal amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public boolean validate() {
        if (!user.isExternal()) {
            return false;
        }
        return amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
