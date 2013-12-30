package com.practicalunittesting;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FormTest {

    @Test
    public void testFormUpdate() {
        // given
        Form f = Mockito.mock(Form.class);
        Mockito.when(f.isUpdateAllowed()).thenReturn(true);

        // when
        boolean result = f.isUpdateAllowed();

        // then
        assertTrue(result);
    }

    @Test
    public void testFormUpdateWithoutMocks() {
        // given
        Form f = new Form();
        f.setUpdateAllowed(true);

        // when - then
        assertTrue(f.isUpdateAllowed());
    }
}
