package com.practicalunittesting;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentMethodTest {

    @Test
    public void shouldGetMethodsForPoland() {
        //given
        List<PaymentMethod> all = Lists.newArrayList(PaymentMethod.values());
        List<PaymentMethod> methodsAvailableInPoland = Lists.newArrayList();
        for (PaymentMethod method : all) {
            if (method.isEligibleForCountry("PL")) {
                methodsAvailableInPoland.add(method);
            }
        }

        //when
        List<PaymentMethod> methodsForCountry = PaymentMethod
                .getMethodsForCountry("PL", all);

        //then
        assertThat(methodsForCountry).isEqualTo(methodsAvailableInPoland);
    }

    @Test
    public void shouldGetMethodsForPolandImproved() {
        //given
        List<PaymentMethod> all = Lists.newArrayList(PaymentMethod.values());
        List<PaymentMethod> methodsAvailableInPoland = Arrays.asList(
                new PaymentMethod[]{
                        PaymentMethod.MASTERCARD,
                        PaymentMethod.VISA
                        // and all other methods available in Poland
                });

        //when
        List<PaymentMethod> methodsForCountry = PaymentMethod
                .getMethodsForCountry("PL", all);

        //then
        assertThat(methodsForCountry).isEqualTo(methodsAvailableInPoland);
    }
}
