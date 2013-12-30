package com.practicalunittesting;

public interface Domain {
    String getAddress();

    boolean isRegisteredInDns();

    int getDnsFailures();
}
