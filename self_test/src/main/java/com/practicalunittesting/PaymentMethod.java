package com.practicalunittesting;

import java.util.List;

import com.google.common.collect.Lists;

public enum PaymentMethod {

    VISA, MASTERCARD, BANK_TRANSFER;

    public boolean isEligibleForCountry(String country) {
        return false;
    }

    public static List<PaymentMethod> getMethodsForCountry(
            String country, List<PaymentMethod> availableMethods) {
        List<PaymentMethod> methodsForCountry = Lists.newArrayList();
        for (PaymentMethod method : availableMethods) {
            if (method.isEligibleForCountry(country)) {
                methodsForCountry.add(method);
            }
        }
        return methodsForCountry;
    }
}
