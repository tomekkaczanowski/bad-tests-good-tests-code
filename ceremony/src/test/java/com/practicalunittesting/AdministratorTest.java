package com.practicalunittesting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdministratorTest {

    @Test
    public void shouldBeAdministrator() {
        //given
        User user = new Administrator();

        //when
        boolean administrator = user.isAdministrator();
        boolean guest = user.isGuest();
        boolean moderator = user.isModerator();

        //then
        assertThat(administrator).isTrue();
        assertThat(guest).isFalse();
        assertThat(moderator).isFalse();
    }

    @Test
    public void shouldBeAdministrator_ShorterVersion() {
        User user = new Administrator();

        assertThat(user.isAdministrator()).isTrue();
        assertThat(user.isGuest()).isFalse();
        assertThat(user.isModerator()).isFalse();
    }
}
