package com.practicalunittesting;

public class InternalUser extends User {

    @Override
    public boolean isExternal() {
        return false;
    }
}
