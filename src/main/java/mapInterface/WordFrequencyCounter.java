package com.collection.mapInterface;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Remove punctuation and convert to lower case
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = text.split("\\s+");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";

        Map<String, Integer> wordFrequency = countWordFrequency(text);

        System.out.println(wordFrequency);
    }
}

