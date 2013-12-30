package com.practicalunittesting;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailSenderTest {

    @Test
    public void shouldBuildEmailSender() {
        // given
        String senderName = "Chuck Norris";
        String senderEmail = "chuck@norris.com";

        // when
        String emailSender = EmailUtils.buildEmailSender(senderName, senderEmail);

        // then
        assertThat(emailSender).isEqualTo("Chuck Norris <chuck@norris.com>");
    }

    @Test
    public void shouldBuildEmailSender_TwoLines() {
        String emailSender = EmailUtils
                .buildEmailSender("Chuck Norris", "chuck@norris.com");
        assertThat(emailSender).isEqualTo("Chuck Norris <chuck@norris.com>");
    }

    @Test
    public void shouldBuildEmailSender_OneLiner() {
        assertThat(EmailUtils.buildEmailSender("Chuck Norris","chuck@norris.com"))
                .isEqualTo("Chuck Norris <chuck@norris.com>");
    }
}
