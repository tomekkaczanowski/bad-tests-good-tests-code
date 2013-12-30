package com.practicalunittesting;

import java.net.MalformedURLException;
import java.net.URL;

public class PrivateMethodTest {

    private Object responseMap;
    private static final String SERVER_ROOT = "http://whatever.com";

    public void testMethod() throws MalformedURLException {
        MockServer server = noSslFileServer();
    }

    private MockServer noSslFileServer() throws MalformedURLException {
        return new MockServer(responseMap, true,
            new URL(SERVER_ROOT).getPort(), false);
    }
}
