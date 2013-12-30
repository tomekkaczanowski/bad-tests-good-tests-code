package com.practicalunittesting;


import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Util2Test {

    User user;

    @Before
    public void setUp() {
        user = mock(User.class);
        given(user.getFullName()).willReturn("username");
    }

    @Test
    public void shouldAddTimestampToGeneratedUrl() throws UnsupportedEncodingException {
        //given
        TimeProvider timeProvider = mock(TimeProvider.class);
        Util2 util = new Util2();
        when(timeProvider.getTime()).thenReturn("12345");
        util.set(timeProvider);

        //when
        String url = util.getUrl(user);

        //then
        assertThat(url).contains("timestamp=12345");
    }
}
