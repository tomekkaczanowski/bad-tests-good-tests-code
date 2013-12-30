package com.practicalunittesting.updated;

import com.practicalunittesting.MyList;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class MyListTryCatchFestAssertTest {

    @Test
    public void shouldThrowExceptionWhenTryingToGetElementOutsideTheList() {
        MyList<Integer> list = new MyList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        try {
            list.get(3);
            fail("Expected IndexOutOfBoundsException but none has been thrown!");
        }
        catch(Exception e) {;
            assertThat(e).isInstanceOf(IndexOutOfBoundsException.class).hasNoCause();
            assertThat(e.getMessage()).contains("Index: 3").contains("Size: 3");
        }
    }
}
