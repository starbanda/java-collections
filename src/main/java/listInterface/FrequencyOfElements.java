package com.collection.listInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = countFrequency(list);
        System.out.println(frequencyMap); // Output: {apple=2, banana=1, orange=1}
    }

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }
}
