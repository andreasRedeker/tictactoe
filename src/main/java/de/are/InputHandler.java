package de.are;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {
    private Scanner scan = new Scanner(System.in);
    private static final Pattern VALID_PATTERN = Pattern.compile("[1-3]:[1-3]");

    public String getInput() {
            return scan.nextLine().trim();
    }

    public void closeScanner() {
        scan.close();
    }

    public boolean isValidFormat(String input) {
        return VALID_PATTERN.matcher(input).matches();
    }

    public int[] formatInput(String input) {
        int row = Character.getNumericValue(input.charAt(0)) - 1;
        int col = Character.getNumericValue(input.charAt(2)) - 1;
        return new int[]{row, col};
    }
}