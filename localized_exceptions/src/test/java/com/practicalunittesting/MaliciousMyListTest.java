package com.practicalunittesting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MaliciousMyListTest {

    @Test(expected=IndexOutOfBoundsException.class)
    public void testMyList() {
        MaliciousMyList<Integer> list = new MaliciousMyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

        list.get(6);
    }


    @Test(expected=IndexOutOfBoundsException.class)
    public void testNegative() {
        MaliciousMyList<Integer> list = new MaliciousMyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(-1);
    }
}
