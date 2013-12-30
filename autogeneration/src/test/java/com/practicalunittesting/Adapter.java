package com.practicalunittesting;

import java.util.Calendar;

public interface Adapter {
    void setTimestamp(Calendar test);

    Calendar getTimestamp();

    void setParam(String test);

    String getParam();
}
