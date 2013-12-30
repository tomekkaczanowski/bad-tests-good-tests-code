package com.practicalunittesting;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SettingsFacadeTest {

    private static final BigDecimal IMPORTANT_VALUE = new BigDecimal("0.123");
    private Settings settings = mock(Settings.class);
    private SettingsFacade settingsFacade = new SettingsFacade(settings);

    @Test
    public void shouldReturnImportantValue() {
        //given
        given(settings.getImportantValue()).willReturn(IMPORTANT_VALUE);

        //when
        BigDecimal importantValue = settingsFacade.getImportantValue();

        //then
        assertThat(importantValue).isEqualByComparingTo(IMPORTANT_VALUE);
    }


    @Test
    public void shouldReturnImportantValueEvolved() {
        //given
        given(settings.getImportantValue()).willReturn(IMPORTANT_VALUE);

        //when
        BigDecimal importantValue = settingsFacade.getImportantValueEvolved();

        //then
        assertThat(importantValue).isEqualByComparingTo(IMPORTANT_VALUE);
    }
}
