package ua.com.foxminded.charscounter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.charscounter.CharacterCount;

public class CharacterCountTest {
    
    CharacterCount result = new CharacterCount();
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsOneWord() {
        String expected =
                    "else\n" +
                    "\"e\" - 2\n" +
                    "\"l\" - 1\n" +
                    "\"s\" - 1\n";

        assertEquals(expected, result.countOfChars("else"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsTwoWords() {
        String expected =
                    "hello world\n" +
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
    void countOfChars_ShouldReturnCertainString_IfInputIsFewWords() {
        String expected =
                    "you are welcome\n" +
                    "\"y\" - 1\n" +
                    "\"o\" - 2\n" +
                    "\"u\" - 1\n" +
                    "\" \" - 2\n" +
                    "\"a\" - 1\n" +
                    "\"r\" - 1\n" +
                    "\"e\" - 3\n" +
                    "\"w\" - 1\n" +
                    "\"l\" - 1\n" +
                    "\"c\" - 1\n" +
                    "\"m\" - 1\n";

        assertEquals(expected, result.countOfChars("you are welcome"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsWordWithSymbol() {
        String expected =
                    "hello!\n" +
                    "\"h\" - 1\n" +
                    "\"e\" - 1\n" +
                    "\"l\" - 2\n" +
                    "\"o\" - 1\n" +
                    "\"!\" - 1\n";

        assertEquals(expected, result.countOfChars("hello!"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsBigNumber() {
        String expected =
                    "808080\n" +
                    "\"8\" - 3\n" +
                    "\"0\" - 3\n";

        assertEquals(expected, result.countOfChars("808080"));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsBlank() {
        String expected =
                    "\n" +
                    "";

        assertEquals(expected, result.countOfChars(""));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsSpace() {
        String expected =
                    " \n" +
                    "\" \" - 1\n";

        assertEquals(expected, result.countOfChars(" "));
    }
    
    @Test
    void countOfChars_ShouldReturnCertainString_IfInputIsNumber() {
        String expected =
                    "1\n" +
                    "\"1\" - 1\n";

        assertEquals(expected, result.countOfChars("1"));
    }

    @Test
    void countOfChars_ShouldReturnResultFromCache_IfInputIsRepeat() throws Throwable {
        HashMap<String, String> expectedCache = new HashMap<>();
        expectedCache.put(" ", " \n\" \" - 1\n");

        result.countOfChars(" ");
        result.countOfChars(" ");
        
        Field cacheFromClass = CharacterCount.class.getDeclaredField("cache");
        cacheFromClass.setAccessible(true);
        
        @SuppressWarnings("unchecked")
        HashMap<String, String> cacheFromResult = (HashMap<String, String>) cacheFromClass.get(result);

        assertEquals(expectedCache.containsKey(" "), cacheFromResult.containsKey(" "));
    }
    
    @Test
    void countOfChars_ShouldReturnResultTrue_IfResultInCache() {
        CharacterCount ñharacterCount = new CharacterCount();

        String firstCall =  ñharacterCount.countOfChars("hello!");
        String secondCall = ñharacterCount.countOfChars("hello!");
        
        assertTrue(firstCall == secondCall);
    }
}
