package com.practicalunittesting;

public class Administrator implements User {
    @Override
    public boolean isAdministrator() {
        return true;
    }

    @Override
    public boolean isGuest() {
        return false;
    }

    @Override
    public boolean isModerator() {
        return false;
    }
}
