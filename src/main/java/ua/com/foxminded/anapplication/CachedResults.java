package ua.com.foxminded.anapplication;

import java.util.HashMap;

public class CachedResults {

    private HashMap<String, String> cache = new HashMap<>();

    public void putResult(String input, String result) {
        if (input == null || result == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }

        cache.put(input, result);
    }

    public String getResult(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }
        
        return cache.containsKey(input) ? cache.get(input) : "";
    }
}
