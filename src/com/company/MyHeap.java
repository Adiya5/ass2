package com.company;

import java.util.ArrayList;

class MyHeap<T extends Comparable> {
    private ArrayList<T> heap;

    private static int parent(int i) {
        return (i - 1) / 2;
    }

    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    private static int rightChild(int i) {
        return i * 2 + 2;
    }

    public MyHeap() {
        this.heap = new ArrayList<T>();
    }

    private T getParent(int i) {
        return this.heap.get(parent(i));
    }

    private T getLeftChild(int i) {
        return this.heap.get(leftChild(i));
    }

    private T getRightChild(int i) {
        return this.heap.get(rightChild(i));
    }

    private void swap(int i1, int i2) {
        T tmp = this.heap.get(i1);
        this.heap.set(i1, this.heap.get(i2));
        this.heap.set(i2, tmp);
    }

    public void insert(T value) {
        int i = this.heap.size();
        this.heap.add(value);

        while (this.getParent(i).compareTo(value) > 0) {
            int parent = parent(i);
            this.swap(parent, i);
            i = parent;
        }
    }

    public T removeRoot() {
        T out = this.heap.get(0);

        T last = this.heap.remove(this.heap.size() - 1);
        int i = 0;
        this.heap.set(i, last);

        T left = this.getLeftChild(i);
        T right = this.getRightChild(i);

        while (last.compareTo(left) < 0 || last.compareTo(right) < 0) {
            int replacer;

            if (last.compareTo(left) < 0 && last.compareTo(right) < 0)
                replacer = (last.compareTo(right) > 0) ? leftChild(i) : rightChild(i);
            else if (last.compareTo(left) < 0)
                replacer = leftChild(i);
            else
                replacer = rightChild(i);
            this.swap(i, replacer);

            i = replacer;
            left = this.getLeftChild(i);
            right = this.getRightChild(i);
        }

        return out;
    }

    public void print() {
        int row = 1;
        int count = 0;

        for (T i : this.heap) {
            if (count == row) {
                System.out.println();
                count = 0;
                row++;
            }

            System.out.print(i + " ");
            count++;
        }
    }

}