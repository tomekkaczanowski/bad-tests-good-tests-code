package com.practicalunittesting;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class Util2 {

    private String baseUrl;
    private TimeProvider timeProvider;

    public String getUrl(User user, String timestamp) throws UnsupportedEncodingException {
        String name = user.getFullName();

        String url = baseUrl
                + "name="+ URLEncoder.encode(name, "UTF-8")
                + "&timestamp="+timestamp;
        return url;
    }

    public String getUrl(User user) throws UnsupportedEncodingException {
        String timestamp = timeProvider.getTime();
        return getUrl(user, timestamp);
    }

    public void set(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }
}
