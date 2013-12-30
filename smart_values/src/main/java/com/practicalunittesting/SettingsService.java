package com.practicalunittesting;

import java.math.BigDecimal;

public interface SettingsService {
    BigDecimal getMinMargin();

    BigDecimal getMaxMargin();

    BigDecimal getPremiumShare();
}
