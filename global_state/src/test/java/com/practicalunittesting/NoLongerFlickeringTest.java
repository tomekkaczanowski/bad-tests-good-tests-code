package com.practicalunittesting;

import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NoLongerFlickeringTest {

    LoggingPropertyConfigurator configurator
            = mock(LoggingPropertyConfigurator.class);
    BaseServletContextListener baseServletContextListener
            = new BaseServletContextListener(configurator);

    @Before
    public void cleanSystemProperties() {
        System.setProperty("logConfig", null);
    }

    @Test
    public void shouldLoadDefaultProperties() {
        baseServletContextListener.contextInitialized(null);
        verify(configurator).configure(any(Properties.class));
    }

    @Test(expected = LoggingInitialisationException.class)
    public void shouldThrowLoggingException() {
        System.setProperty("logConfig", "nonExistingFile");
        baseServletContextListener.contextInitialized(null);
    }
}
