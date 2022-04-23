package com.company;

import java.util.ArrayList;

public class MyStack <T extends Comparable> {
    private ArrayList<T> array = new ArrayList<>();

    public MyStack(ArrayList<T> array) {
        this.array = array;
    }

    public void push_back(T value) {
        array.add(value);
    }

    public void pop_back() {
        array.remove(array.size() - 1);
    }

    public T peek() {
        return array.get(array.size() - 1);
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void clear() {
        array.clear();
    }
}
