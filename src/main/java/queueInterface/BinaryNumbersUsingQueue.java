package com.collection.queueInterface;

import java.util.*;

public class BinaryNumbersUsingQueue {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");  // Start with the first binary number

        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            result.add(current);

            // Append "0" and "1" to the current binary number
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaryNumbers = generateBinaryNumbers(n);
        System.out.println("First " + n + " Binary Numbers: " + binaryNumbers);
    }
}
