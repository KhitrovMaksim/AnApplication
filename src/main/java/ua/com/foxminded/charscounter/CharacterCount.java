package ua.com.foxminded.charscounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
    private static String LINE_END = "\n";
    private static String QUOTE = "\"";
    private static String QUOTE_WITH_DASH = "\" - ";

    private HashMap<String, String> cache = new HashMap<>();

    public String countOfChars(String input) {
        Map<Character, Integer> charsCounter = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder("");

        if (input == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }

        if (cache.containsKey(input)) {
            result.append(cache.get(input));
        } else {
            for (char inputsChar : input.toCharArray()) {
                if (charsCounter.containsKey(inputsChar)) {
                    charsCounter.put(inputsChar, charsCounter.get(inputsChar) + 1);
                } else {
                    charsCounter.put(inputsChar, 1);
                }
            }
            result.append(input).append(LINE_END).append(composeResult(charsCounter));

            cache.put(input, result.toString());
        }

        return result.toString();
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
