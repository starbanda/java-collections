package com.collection.queueInterface;

import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push an element to the stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop the top element from the stack
    public int pop() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }

        // Move all elements from queue1 to queue2 except the last element
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top of the stack
        int top = queue1.poll();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            return -1; // Stack is empty
        }

        // Move all elements from queue1 to queue2 except the last element
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top of the stack
        int top = queue1.peek();

        // Move the element to queue2
        queue2.add(queue1.poll());

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Pop: " + stack.pop()); // Should print 3
        System.out.println("Top: " + stack.top()); // Should print 2
    }
}

