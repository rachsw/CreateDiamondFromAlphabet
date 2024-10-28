package org.example;

import static org.example.App.printDiamondWithUpperCaseAlphabet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AppTest {

    public static final String UnsupportedOperationMessage = "Only inputs of upper cases letters a-z accepted.";

    @Test
    void testAList() {
        List<String> actual = printDiamondWithUpperCaseAlphabet('A');
        assertEquals(Collections.singletonList("A"), actual);
    }

    @Test
    void testBList() {
        List<String> actual = printDiamondWithUpperCaseAlphabet('B');
        assertEquals(3, actual.size());
        assertEquals(Arrays.asList(" A ", "B B", " A "), actual);
    }

    @Test
    void testCList() {
        List<String> actual = printDiamondWithUpperCaseAlphabet('C');
        assertEquals(5, actual.size());
        assertEquals(Arrays.asList("  A  ", " B B ", "C   C", " B B ", "  A  "), actual);
    }

    @Test
    void testZList() {
        List<String> actual = printDiamondWithUpperCaseAlphabet('Z');
        assertEquals(51, actual.size());
        assertEquals("Z                                                 Z", actual.get(25));
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', 'a', '@', '/', '9', '{', ' ', 'z'})
    void testThrowsExceptionForInvalidInputs(char invalidInput) {
        UnsupportedOperationException exception =
            assertThrows(UnsupportedOperationException.class, () -> {
                printDiamondWithUpperCaseAlphabet(invalidInput);
            });
        assertEquals(UnsupportedOperationMessage, exception.getMessage());
    }
}
