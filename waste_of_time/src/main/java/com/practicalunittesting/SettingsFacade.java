package com.practicalunittesting;

import java.math.BigDecimal;

public class SettingsFacade {
    private static final BigDecimal DEFAULT_VALUE = BigDecimal.ZERO;
    private final Settings settings;

    public SettingsFacade(Settings settings) {
        this.settings = settings;
    }

    public BigDecimal getImportantValue() {
        return settings.getImportantValue();
    }

    public BigDecimal getImportantValueEvolved() {
        return (settings.getImportantValue() != null)
                ? settings.getImportantValue() : DEFAULT_VALUE;
    }
}
