package com.practicalunittesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class QueryTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][] { {"48", true}, {"+48", true},
                {"++48", true}, {"+48503", true}, {"+4", false},
                {"++4", false}, {"", false},
                {null, false}, {"  ", false}, };
    }

    @Test(dataProvider = "data")
    public void testQueryVerification(String query, boolean expected) {
        assertEquals(expected, FieldVerifier.isValidQuery(query));
    }
}
