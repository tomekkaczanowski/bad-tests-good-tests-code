package com.practicalunittesting;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class Util {

    private String baseUrl;

    public String getUrl(User user, String timestamp) throws UnsupportedEncodingException {
        String name = user.getFullName();

        String url = baseUrl
                + "name="+ URLEncoder.encode(name, "UTF-8")
                + "&timestamp="+timestamp;
        return url;
    }

    public String getUrl(User user) throws UnsupportedEncodingException {
        Date date = new Date();
        Long time = (date.getTime() / 1000); //convert ms to seconds
        String timestamp = time.toString();
        return getUrl(user, timestamp);
    }
}
