package com.practicalunittesting;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class UserRegisterController {

    private UserService userService;
    private MailSender mailSender;

    public UserRegisterController(UserService userService, MailSender mailSender) {
        this.userService = userService;
        this.mailSender = mailSender;
    }

    public ModelAndView registerUser(UserData userData, BindingResult result,
                                     HttpServletRequest request) {
        if (result.hasErrors()) {
            return showRegisterForm(request, false);
        }

        User savedUser = userService.saveNewUser(userData);
        mailSender.sendRegistrationInfo(savedUser);
        return new ModelAndView("redirect:/signin");
    }

    private ModelAndView showRegisterForm(HttpServletRequest request, boolean flag) {
        return null;
    }
}
