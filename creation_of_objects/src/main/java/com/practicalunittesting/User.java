package com.practicalunittesting;

import java.util.Date;

public class User {
    private Company company;
    private UserState state;

    public User() {

    }
    public User(String mail, String firstName, String lastName, String password, String timeZone, UserState status, Address address) {

    }

    public void setAccessCode(String accessCode) {

    }

    public void setRegistrationDate(Date registrationDate) {

    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setUserState(UserState userState) {
        this.state = userState;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
}
