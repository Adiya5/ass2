package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("My Min Heap: ");
        MyHeap<Integer> minHeap = new MyHeap<>();
        minHeap.insert(3984);
        minHeap.insert(184);
        minHeap.insert(2040);
        minHeap.insert(39);
        minHeap.insert(77);
        minHeap.insert(1);
        minHeap.insert(4);
        minHeap.insert(987);
        minHeap.insert(2747);
        minHeap.insert(72);
        minHeap.insert(872);
        minHeap.insert(238);
        minHeap.print();
        System.out.println("My minimum is " + minHeap.removeRoot());
        minHeap.print();
    }
}
