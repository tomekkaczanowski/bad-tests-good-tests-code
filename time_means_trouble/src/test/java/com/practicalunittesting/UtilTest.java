package com.practicalunittesting;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class UtilTest {

    User user = mock(User.class);

    @Test
    public void shouldUseTimestampMethod() throws UnsupportedEncodingException {
        //given
        Util util = new Util();
        Util spyUtil = spy(util);

        //when
        spyUtil.getUrl(user);

        //then
        verify(spyUtil).getUrl(eq(user), anyString());
    }
}
