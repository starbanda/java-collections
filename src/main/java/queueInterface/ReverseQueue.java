package com.collection.queueInterface;

import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }

        int front = queue.poll();  // Remove the front element
        queue = reverseQueue(queue);  // Recursively reverse the rest of the queue

        queue.add(front);  // Add the front element to the end of the queue
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);

        queue = reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

