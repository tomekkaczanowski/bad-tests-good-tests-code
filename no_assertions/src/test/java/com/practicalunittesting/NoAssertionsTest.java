package com.practicalunittesting;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.concurrent.Executor;

import static org.assertj.core.api.Assertions.assertThat;

public class NoAssertionsTest {

    Format format = null;

    @Test
    public void originalTest() {
        IResult result = format.execute();
        System.out.println(result.size());
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            IResult r = (IResult) iter.next();
            System.out.println(r.getMessage());
        }
    }

    @Test
    public void betterVersion() {
        IResult result = format.execute();
        assertThat(result.size()).isEqualTo(3);
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            IResult r = (IResult) iter.next();
            assertThat(r.getMessage()).contains("error");
        }

    }
}