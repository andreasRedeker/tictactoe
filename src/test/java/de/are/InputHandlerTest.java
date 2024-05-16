package de.are;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputHandlerTest {

    private InputHandler inputHandler = new InputHandler();

    @Test
    public void testIsValidFormat() {
        assertTrue(inputHandler.isValidFormat("1:1"));
        assertTrue(inputHandler.isValidFormat("2:1"));
        assertTrue(inputHandler.isValidFormat("3:3"));
        assertFalse(inputHandler.isValidFormat("4:1"));
        assertFalse(inputHandler.isValidFormat("1:4"));
        assertFalse(inputHandler.isValidFormat("0:0"));
        assertFalse(inputHandler.isValidFormat("3-3"));
        assertFalse(inputHandler.isValidFormat("1_2"));
        assertFalse(inputHandler.isValidFormat("asdf"));
        assertFalse(inputHandler.isValidFormat(""));
    }

    @Test
    public void testFormatInput() {
        int[] expected1 = {0, 0};
        int[] expected2 = {2, 2};
        int[] expected3 = {0, 1};
        assertArrayEquals(expected1, inputHandler.formatInput("1:1"));
        assertArrayEquals(expected2, inputHandler.formatInput("3:3"));
        assertArrayEquals(expected3, inputHandler.formatInput("1:2"));
    }
}