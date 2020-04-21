package ua.com.foxminded.anapplication;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
    private HashMap<String, String> cache = new HashMap<>();
    private static String LINE_END = "\n";
    private static String QUOTE = "\"";
    private static String QUOTE_WITH_DASH = "\" - ";

    public String countOfChars(String inputString) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        String result;

        if (inputString == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }

        if (cache.containsKey(inputString)) {
            result = cache.get(inputString);
        } else {
            for (char inputsChar : inputString.toCharArray()) {
                if (charCountMap.containsKey(inputsChar)) {
                    charCountMap.put(inputsChar, charCountMap.get(inputsChar) + 1);
                } else {
                    charCountMap.put(inputsChar, 1);
                }
            }
            result = composeResult(charCountMap);

            cache.put(inputString, result);
        }

        return result;
    }

    private String composeResult(Map<Character, Integer> charCountMap) {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append(QUOTE).append(entry.getKey()).append(QUOTE_WITH_DASH).append(entry.getValue())
                    .append(LINE_END);
        }

        return result.toString();
    }
}
