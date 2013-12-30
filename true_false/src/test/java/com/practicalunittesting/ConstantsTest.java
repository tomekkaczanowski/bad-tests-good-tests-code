package com.practicalunittesting;

import java.net.MalformedURLException;
import java.net.URL;

public class ConstantsTest {

    public static final boolean RESPONSE_IS_A_FILE = true;
    public static final boolean NO_SSL = false;
    private Object responseMap;
    private static final String SERVER_ROOT = "http://whatever.com";

    public void testMethod() throws MalformedURLException {
        MockServer server = new MockServer(responseMap, RESPONSE_IS_A_FILE,
            new URL(SERVER_ROOT).getPort(), NO_SSL);
    }
}
