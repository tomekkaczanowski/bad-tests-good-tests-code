package com.practicalunittesting.zero;

public class PaymentService {
    public static final int REPORT_COUNT = 50;
    private PaymentAdapter paymentAdapter;

    public PaymentService(PaymentAdapter paymentAdapter) {
        this.paymentAdapter = paymentAdapter;
    }

    public double getRevenue(Client client) {
        return paymentAdapter.getRevenue(client, REPORT_COUNT);
    }
}
