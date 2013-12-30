package com.practicalunittesting;

import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExpectedExceptionsTest {

    private static final String DOMAIN_ADDRESS = "some.address";
    private static final int DNS_FAILURES = 1;

    private DnsService dnsService = mock(DnsService.class);
    private DomainService domainService = mock(DomainService.class);
    private Domain domain = mock(Domain.class);
    private DomainRegistrator domainRegistrator = new DomainRegistrator();

    @Test(expected = RuntimeException.class)
    public void shouldSaveFailureInformationWhenExceptionOccurWhenAddingDomain() {
        //given
        doThrow(new RuntimeException()).when(dnsService)
                .addDomainIfMissing(DOMAIN_ADDRESS);

        //when
        domainRegistrator.registerDomain(domain);

        //then
        verify(domainService)
                .saveDomain(domain, false, DNS_FAILURES + 1);
    }

    @Test
    public void shouldSaveFailureInformationWhenExceptionOccurWhenAddingDomainBetterVersion() {
        //given
        doThrow(new RuntimeException()).when(dnsService)
                .addDomainIfMissing(DOMAIN_ADDRESS);

        //when
        catchException(domainRegistrator).registerDomain(domain);

        //then
        verify(domainService)
                .saveDomain(domain, false, DNS_FAILURES + 1);
        assertThat(caughtException()).isInstanceOf(RuntimeException.class);
    }
}
