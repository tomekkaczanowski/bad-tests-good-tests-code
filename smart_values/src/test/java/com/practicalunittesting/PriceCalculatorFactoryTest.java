package com.practicalunittesting;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PriceCalculatorFactoryTest {
    SettingsService settings = mock(SettingsService.class);
    @Test
    public void shouldCreatePriceCalculator() {
//given
        given(settings.getMinMargin()).willReturn(new BigDecimal(20));
        given(settings.getMaxMargin()).willReturn(new BigDecimal(50));
        given(settings.getPremiumShare()).willReturn(new BigDecimal(50));
//when
        PriceCalculator calculator
                = new PriceCalculatorFactory(settings).create();
//then
        assertThat(calculator)
                .isEqualTo(new PriceCalculator(new BigDecimal(20),
                        new BigDecimal(50), new BigDecimal(50)));
    }
}
