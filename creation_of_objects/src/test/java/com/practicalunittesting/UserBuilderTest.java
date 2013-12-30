package com.practicalunittesting;

import org.junit.Before;
import org.junit.Test;

public class UserBuilderTest {

    private Company company;

    @Before
    public void initialize() {
        User notVerifiedUser = UserBuilder.createUser(UserState.NOT_VERIFIED)
                .create();

    }

    @Test
    public void shouldCommitTransaction() {
        User user = UserBuilder.createActiveUser()
                .create();

    }

    @Test
    public void shouldGetUserByCompanyData() {
        User user = UserBuilder.createActiveUser()
                .withCompany(company)
                .create();

    }
}
