package com.practicalunittesting;

import org.testng.annotations.Test;

import java.util.GregorianCalendar;

import static org.testng.Assert.assertEquals;

@Test
public class AutogenerationTest {

    Adapter adapter;
    public void testSetGetTimestamp() throws Exception {
// JUnitDoclet begin method setTimestamp getTimestamp
        java.util.Calendar[] tests = {new GregorianCalendar(), null};
        for (int i = 0; i < tests.length; i++) {
            adapter.setTimestamp(tests[i]);
            assertEquals(tests[i], adapter.getTimestamp());
        }
    }
    // JUnitDoclet end method setTimestamp getTimestamp
    public void testSetGetParam() throws Exception {
// JUnitDoclet begin method setParam getParam
        String[] tests = {"a", "aaa", "---", "23121313", "", null};
        for (int i = 0; i < tests.length; i++) {
            adapter.setParam(tests[i]);
            assertEquals(tests[i], adapter.getParam());
        }
// JUnitDoclet end method setParam getParam

    }
}