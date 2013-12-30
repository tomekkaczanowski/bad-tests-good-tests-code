package com.practicalunittesting;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    public void shouldRecognizeTransactionsWithZeroValueAsInvalid() {
        //given
        Transaction transaction = new Transaction(BigDecimal.ZERO, new InternalUser());

        //when
        boolean actual = transaction.validate();

        //then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldRecognizeTransactionWithNegativeValueAsInvalid() {
        //given
        Transaction transaction = new Transaction(BigDecimal.ONE.negate(), new InternalUser());

        //when
        boolean actual = transaction.validate();

        //then
        assertThat(actual).isFalse();
    }
}
