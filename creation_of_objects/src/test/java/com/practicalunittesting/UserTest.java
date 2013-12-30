package com.practicalunittesting;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserTest {

    private Company company;
    private Address address;
    private Date oneDayAgo;

    @Before
    public void initialize() {
        User user = new User("email@example.com", "Example", "Example", "qwerty",
                "Europe/Warsaw", UserState.NOT_VERIFIED, new Address());

    }

    @Test
    public void shouldCommitTransaction() {
        User user = new User("firstName", "lastName", "password",
                "email@example.com", "qwerty", UserState.ACTIVE, new Address());
        DateTime oneDayAgo = new DateTime().withTimeAtStartOfDay().minusDays(1);
        user.setRegistrationDate(oneDayAgo.toDate());
        user.setAccessCode("qwerty");

    }

    @Test
    public void shouldGetUserByCompanyData() {
        User user = new User("email", "FirstName", "LastName", "Password",
                "Europe/Warsaw", UserState.ACTIVE, address);
        user.setRegistrationDate(new Date());
        user.setCompany(company);
        user.setAccessCode("Access Code");

    }


}
