package ua.com.foxminded.anapplication;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
    private static String LINE_END = "\n";
    private static String QUOTE = "\"";
    private static String QUOTE_WITH_DASH = "\" - ";

    public String countOfChars(String inputString) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        StringBuilder resultCountMap = new StringBuilder();

        if (inputString == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }

        for (char inputsChar : inputString.toCharArray()) {
            if (charCountMap.containsKey(inputsChar)) {
                charCountMap.put(inputsChar, charCountMap.get(inputsChar) + 1);
            } else {
                charCountMap.put(inputsChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            resultCountMap.append(QUOTE).append(entry.getKey()).append(QUOTE_WITH_DASH).append(entry.getValue())
                    .append(LINE_END);
        }

        return resultCountMap.toString();
    }
}
