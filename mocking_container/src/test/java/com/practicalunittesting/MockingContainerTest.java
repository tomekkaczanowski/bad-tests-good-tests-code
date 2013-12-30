package com.practicalunittesting;

import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockingContainerTest {

    @Test
    public void shouldAddTimeZoneToModelAndView() {
        //given
        Context context = mock(Context.class);
        ModelAndView modelAndView = mock(ModelAndView.class);
        given(context.getTimezone()).willReturn("timezone X");

        //when
        new UserDataInterceptor(context)
                .postHandle(null, null, null, modelAndView);

        //then
        verify(modelAndView).addObject("timezone", "timezone X");
    }

    @Test
    public void shouldAddTimeZoneToModelAndView_Improved() {
        //given
        Context context = mock(Context.class);
        ModelAndView modelAndView = new ModelAndView();
        given(context.getTimezone()).willReturn("timezone X");

        //when
        new UserDataInterceptor(context)
                .postHandle(null, null, null, modelAndView);

        //then
        //assertThat(modelAndView).contains("timezone", "timezone X");
    }
}
