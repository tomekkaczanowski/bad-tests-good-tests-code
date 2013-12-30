package com.practicalunittesting;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserRegisterControllerTest {

    // mocks
    UserData userData = mock(UserData.class);
    UserService userService = mock(UserService.class);
    BindingResult bindingResult = mock(BindingResult.class);
    MailSender mailSender = mock(MailSender.class);
    User user = mock(User.class);
    HttpServletRequest request = mock(HttpServletRequest.class);

    // sut
    UserRegisterController userRegisterController =  new UserRegisterController(userService, mailSender);

    @Test
    public void shouldReturnRedirectViewAndSendEmail() {
        //given
        given(bindingResult.hasErrors()).willReturn(false);
        given(userService.saveNewUser(eq(userData)))
                .willReturn(user);

        //when
        ModelAndView userRegisterResult = userRegisterController
                .registerUser(userData, bindingResult, request);

        //then
        assertThat(userRegisterResult.getViewName())
                .isEqualTo("redirect:/signin");
        verify(mailSender).sendRegistrationInfo(user);
    }

    @Test
    public void shouldRedirectToSigninPageWhenNoErrors() {
        //given
        given(bindingResult.hasErrors()).willReturn(false);

        //when
        ModelAndView userRegisterResult = userRegisterController
                .registerUser(userData, bindingResult, request);

        //then
        assertThat(userRegisterResult.getViewName())
                .isEqualTo("redirect:/signin");
    }

    @Test
    public void shouldNotifyAboutNewUserRegistration() {
        //given
        given(bindingResult.hasErrors()).willReturn(false);
        given(userService.saveNewUser(eq(userData)))
                .willReturn(user);

        //when
        userRegisterController.registerUser(userData, bindingResult, request);

        //then
        verify(mailSender).sendRegistrationInfo(user);
    }
}
