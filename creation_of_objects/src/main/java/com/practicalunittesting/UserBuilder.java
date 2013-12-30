package com.practicalunittesting;

public class UserBuilder {
    private UserState state;
    private Company company;

    public static UserBuilder createUser(UserState state) {
        UserBuilder builder = new UserBuilder();
        builder.setState(state);
        return builder;
    }

    public UserBuilder setState(UserState state) {
        this.state = state;
        return this;
    }

    public User create() {
        User user = new User();
        user.setUserState(this.state);
        user.setCompany(this.company);
        return user;
    }

    public static UserBuilder createActiveUser() {
        return createUser(UserState.ACTIVE);
    }

    public UserBuilder withCompany(Company company) {
        this.company = company;
        return this;
    }
}
