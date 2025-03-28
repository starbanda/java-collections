package com.collection.listInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(list);
        System.out.println(result); // Output: [3, 1, 2, 4]
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer element : list) {
            if (!seen.contains(element)) {
                seen.add(element);
                result.add(element);
            }
        }
        return result;
    }
}
