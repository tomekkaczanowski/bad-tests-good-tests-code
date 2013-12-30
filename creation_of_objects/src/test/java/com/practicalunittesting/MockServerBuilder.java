package com.practicalunittesting;


import java.util.Map;

public class MockServerBuilder {
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
            return new MockServer(responseMap, responseType, serverUrl, ssl);
        }
    }
