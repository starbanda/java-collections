package com.collection.listInterface;

import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        List<Integer> rotatedList = rotateList(list, 2);
        System.out.println(rotatedList); // Output: [30, 40, 50, 10, 20]
    }

    public static List<Integer> rotateList(List<Integer> list, int n) {
        int size = list.size();
        List<Integer> rotatedList = new ArrayList<>();

        // Adjust n to ensure it's within bounds
        n = n % size;

        for (int i = n; i < size; i++) {
            rotatedList.add(list.get(i));
        }

        for (int i = 0; i < n; i++) {
            rotatedList.add(list.get(i));
        }

        return rotatedList;
    }
}