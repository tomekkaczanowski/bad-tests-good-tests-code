package com.practicalunittesting;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class ImprovedPriceCalculatorFactoryTest {
    SettingsService settings = mock(SettingsService.class);
    private static final BigDecimal MIN_MARGIN = new BigDecimal(20);
    private static final BigDecimal MAX_MARGIN = new BigDecimal(30);
    private static final BigDecimal PREMIUM_SHARE = new BigDecimal(40);
    @Test
    public void shouldCreatePriceCalculator() {
//given
        given(settings.getMinMargin()).willReturn(MIN_MARGIN);
        given(settings.getMaxMargin()).willReturn(MAX_MARGIN);
        given(settings.getPremiumShare()).willReturn(PREMIUM_SHARE);
        //when
        PriceCalculator calculator
                = new PriceCalculatorFactory(settings).create();
        //then
        assertThat(calculator).isEqualTo(
                new PriceCalculator(MIN_MARGIN, MAX_MARGIN, PREMIUM_SHARE));
    }
}
