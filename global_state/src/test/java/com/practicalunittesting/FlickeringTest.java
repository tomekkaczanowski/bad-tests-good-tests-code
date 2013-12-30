package com.practicalunittesting;

import org.junit.Test;

import java.util.Properties;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FlickeringTest {

    LoggingPropertyConfigurator configurator
            = mock(LoggingPropertyConfigurator.class);
    BaseServletContextListener baseServletContextListener
            = new BaseServletContextListener(configurator);

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
