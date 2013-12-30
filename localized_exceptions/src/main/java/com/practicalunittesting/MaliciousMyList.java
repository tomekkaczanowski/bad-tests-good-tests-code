package com.practicalunittesting;

public class MaliciousMyList<T> {

    public MaliciousMyList() {
        throw new IndexOutOfBoundsException();
    }

    public void add(T i) {
    }

    public T get(T i) {
        return null;
    }
}
