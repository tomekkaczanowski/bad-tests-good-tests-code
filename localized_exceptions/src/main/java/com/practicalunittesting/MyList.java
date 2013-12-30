package com.practicalunittesting;

import java.util.ArrayList;
import java.util.List;

public class MyList<E> {
    private List<E> list;

    public MyList() {
        this.list = new ArrayList<E>();
    }

    public void add(E e) {
        list.add(e);
    }

    public E get(int i) {
        return list.get(i);
    }
}
