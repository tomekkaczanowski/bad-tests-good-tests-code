package com.practicalunittesting;

public interface DomainService {
    void saveDomain(Domain domain, boolean registeredInDns, int tryNb);
}
