package com.collection.listInterface;

import java.util.LinkedList;

public class NthElementFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String result = findNthFromEnd(list, 2);
        System.out.println(result); // Output: D
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        LinkedList<String> temp = new LinkedList<>(list);
        int size = list.size();

        // Check if n is valid
        if (n <= 0 || n > size) {
            return null;
        }

        // Move the pointer to the correct position
        for (int i = 0; i < size - n; i++) {
            temp.removeFirst();
        }

        return temp.getFirst();
    }
}
