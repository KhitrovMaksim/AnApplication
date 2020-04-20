package ua.com.foxminded.anapplication;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
    private static String LINE_END = "\n";
    private static String QUOTE = "\"";
    private static String QUOTE_WITH_DASH = "\" - ";

    public String countOfChars(String inputString) {

        if (inputString == null) {
            throw new IllegalArgumentException("Inputs data cannot be null.");
        }

        Map<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
        StringBuilder resultCountMap = new StringBuilder();
        char[] strArray = inputString.toCharArray();

        for (char c : strArray) {

            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            resultCountMap.append(QUOTE).append(entry.getKey()).append(QUOTE_WITH_DASH).append(entry.getValue())
                    .append(LINE_END);
        }

        return resultCountMap.toString();
    }
}
