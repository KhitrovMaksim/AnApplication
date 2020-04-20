package ua.com.foxminded.anapplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterCountTest {
    
    CharacterCount result = new CharacterCount();
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsOneWord() {
        String expected =
            "\"e\" - 2\n" +
            "\"l\" - 1\n" +
            "\"s\" - 1\n";

        assertEquals(expected, result.countOfChars("else"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsTwoWords() {
        String expected =
                    "\"h\" - 1\n" +
                    "\"e\" - 1\n" +
                    "\"l\" - 3\n" +
                    "\"o\" - 2\n" +
                    "\" \" - 1\n" +
                    "\"w\" - 1\n" +
                    "\"r\" - 1\n" +
                    "\"d\" - 1\n";

        assertEquals(expected, result.countOfChars("hello world"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsBlank() {
        String expected = "";

        assertEquals(expected, result.countOfChars(""));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsSpace() {
        String expected = "\" \" - 1\n";

        assertEquals(expected, result.countOfChars(" "));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsNumber() {
        String expected = "\"1\" - 1\n";

        assertEquals(expected, result.countOfChars("1"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsBigNumber() {
        String expected = 
                "\"8\" - 3\n" +
                "\"0\" - 3\n";

        assertEquals(expected, result.countOfChars("808080"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsWordWithSymbol() {
        String expected = 
                "\"h\" - 1\n" +
                "\"e\" - 1\n" +
                "\"l\" - 2\n" +
                "\"o\" - 1\n" +
                "\"!\" - 1\n";

        assertEquals(expected, result.countOfChars("hello!"));
    }
}
