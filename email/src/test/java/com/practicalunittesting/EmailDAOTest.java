package com.practicalunittesting;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailDAOTest {

    private EmailDAO emailDAO;

    @Test
    public void shouldRemoveEmailsByState() {
        //given
        Email pending = createAndSaveEmail("pending","content pending",
                "abc@def.com", Email.PENDING);
        Email failed = createAndSaveEmail("failed","content failed",
                "abc@def.com", Email.FAILED);
        Email sent = createAndSaveEmail("sent","content sent",
                "abc@def.com", Email.SENT);

        //when
        emailDAO.removeByState(Email.FAILED);

        //then
        assertThat(emailDAO.findAll()).doesNotContain(failed);

        assertThat(emailDAO.findAll())
                .isNotEmpty()
                .doesNotContain(failed);

        assertThat(emailDAO.findAll())
                .contains(pending, sent)
                .doesNotContain(failed);
    }



    private Email createAndSaveEmail(String title, String content, String address, String state) {
        return null;
    }
}
