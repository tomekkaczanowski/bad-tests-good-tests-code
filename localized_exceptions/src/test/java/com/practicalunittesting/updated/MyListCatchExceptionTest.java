package com.practicalunittesting.updated;

import com.practicalunittesting.MyList;
import org.junit.Test;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.assertj.core.api.Assertions.assertThat;

public class MyListCatchExceptionTest {

    @Test
    public void shouldThrowExceptionWhenTryingToGetElementOutsideTheList() {
        MyList<Integer> list = new MyList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        catchException(list).get(3);

        assertThat(caughtException()).isExactlyInstanceOf(IndexOutOfBoundsException.class);
    }
}
