package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
public class ImprovedQueryTest {

    @DataProvider
    public Object[][] validQueries() {
        return new Object[][] { {"48"}, {"48123"},
                {"+48"}, {"++48"}, {"+48503"}};
    }

    @Test(dataProvider = "validQueries")
    public void shouldRecognizeValidQueries(String validQuery) {
        assertTrue(FieldVerifier.isValidQuery(validQuery));
    }

    @DataProvider
    public Object[][] invalidQueries() {
        return new Object[][] {
                {"+4"}, {"++4"},
                {""}, {null}, {"  "} };
    }

    @Test(dataProvider = "invalidQueries")
    public void shouldRejectInvalidQueries(String invalidQuery) {
        assertFalse(FieldVerifier.isValidQuery(invalidQuery));
    }
}
