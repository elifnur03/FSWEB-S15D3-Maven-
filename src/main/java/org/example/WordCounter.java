package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String, Integer> calculateWord() {

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance.";

        Map<String, Integer> wordMap = new HashMap<>();

        String[] words = text
                .toLowerCase()
                .replaceAll("[^a-zA-Z ]","")
                .split("\\s+");

        for(String word : words){

            if(wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word) + 1);
            } else{
                wordMap.put(word,1);
            }

        }

        return wordMap;
    }
}