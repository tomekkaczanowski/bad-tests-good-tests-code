package com.practicalunittesting;

public class DomainRegistrator {

    private DnsService dnsService;
    private DomainService domainService;

    public void registerDomain(Domain domain) {
        try {
            dnsService.addDomainIfMissing(domain.getAddress());
        } catch (RuntimeException ex) {
            domainService.saveDomain(domain, domain.isRegisteredInDns(),
                    domain.getDnsFailures() + 1);
            throw ex;
        }
        domainService.saveDomain(domain, domain.isRegisteredInDns(),
                domain.getDnsFailures());
    }

}
