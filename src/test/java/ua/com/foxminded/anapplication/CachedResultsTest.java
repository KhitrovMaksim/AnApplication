package ua.com.foxminded.anapplication;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CachedResultsTest {

    CachedResults cache = new CachedResults();

    @Test
    void putResult_ShouldReturnThrowsException_IfInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            cache.putResult(null, " ");
        });
    }

    @Test
    void putResult_ShouldReturnThrowsException_IfResultIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            cache.putResult(" ", null);
        });
    }

    @Test
    void getResult_ShouldReturnThrowsException_IfInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            cache.getResult(null);
        });
    }

}
