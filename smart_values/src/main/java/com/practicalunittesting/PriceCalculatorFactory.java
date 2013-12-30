package com.practicalunittesting;

import java.math.BigDecimal;

public class PriceCalculatorFactory {

    private SettingsService settingsService;

    public PriceCalculatorFactory(SettingsService settings) {

    }

    public PriceCalculator create() {
        BigDecimal minMargin = settingsService.getMinMargin();
        BigDecimal maxMargin = settingsService.getMaxMargin();
        BigDecimal premiumShare = settingsService.getPremiumShare();
        return new PriceCalculator(minMargin, maxMargin, premiumShare);
    }
}