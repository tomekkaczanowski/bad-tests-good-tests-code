package com.practicalunittesting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private UserDAO dao;
    private UserService userService = new UserService(dao);

    @Test
    public void shouldAddUser() {
        User user = new User();
        userService.save(user);
        assertEquals(dao.getNbOfUsers(), 1);
    }

    @Test
    public void shouldAddUser_Improved() {
        int nb = dao.getNbOfUsers();
        User user = new User();
        userService.save(user);
        assertEquals(dao.getNbOfUsers(), nb + 1);
    }
}
