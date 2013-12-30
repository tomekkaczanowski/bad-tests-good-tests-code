package com.practicalunittesting.zero;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PaymentServiceNonZeroTest {

    PaymentAdapter paymentAdapter = mock(PaymentAdapter.class);
    PaymentService paymentService = new PaymentService(paymentAdapter);

    @Test
    public void shouldReturnRevenueForClient() {
        //given
        final Client client = new Client();
        given(paymentAdapter.getRevenue(client, PaymentService.REPORT_COUNT)).willReturn(1.23);

        //when
        double actual = paymentService.getRevenue(client);

        //then
        assertThat(actual).isEqualTo(1.23d);
    }
}