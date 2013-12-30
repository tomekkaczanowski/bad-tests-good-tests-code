package com.practicalunittesting;

import java.net.MalformedURLException;
import java.util.Map;

import static com.practicalunittesting.ResponseType.FILE;

public class BuilderTest {

    private Map<String, String> responseMap;
    private static final String SERVER_ROOT = "http://whatever.com";

    public void testMethod() throws MalformedURLException {
        MockServer server = new MockServerBuilder()
                .withResponse(responseMap)
                .withResponseType(FILE)
                .withUrl(SERVER_ROOT)
                .withoutSsl()
                .create();
    }

    private class MockServerBuilder {
        private Map<String, String> responseMap;
        private ResponseType responseType;
        private String serverUrl;
        private boolean ssl;

        public MockServerBuilder withResponse(Map<String, String> responseMap) {
            this.responseMap = responseMap;
            return this;
        }

        public MockServerBuilder withResponseType(ResponseType responseType) {
            this.responseType = responseType;
            return this;
        }

        public MockServerBuilder withUrl(String serverUrl) {
            this.serverUrl = serverUrl;
            return this;
        }

        public MockServerBuilder withoutSsl() {
            this.ssl = false;
            return this;
        }

        public MockServer create() {
            MockServer server = new MockServer();
            server.setResponseMap(responseMap);
            server.setResponseType(responseType);
            server.setUrl(serverUrl);
            server.setSsl(ssl);
            return server;
        }
    }
}
