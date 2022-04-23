package com.company;

import java.util.ArrayList;

public class MyQueue <T extends Comparable> {
    private ArrayList<T> array = new ArrayList<>();

    public MyQueue(ArrayList<T> array) {
        this.array = array;
    }

    public void enqueue(T value) {
        array.add(value);
    }

    public void dequeue() {
        array.remove(0);
    }

    public T peek() {
        return array.get(0);
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
