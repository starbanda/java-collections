package com.collection.queueInterface;

import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size, head, tail;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        head = tail = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;

        // If the buffer is full, overwrite the oldest element
        if (tail == head) {
            head = (head + 1) % size;
        }
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = head; i != tail; i = (i + 1) % size) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display(); // Should display [1, 2, 3]

        buffer.insert(4);
        buffer.display(); // Should display [2, 3, 4]
    }
}

