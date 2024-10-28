package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    // can replace with lower case letters
    static int ASCI_NUM_a = 97;
    static int ASCI_NUM_z = 122;
    static int ASCI_NUM_A = 65;
    static int ASCI_NUM_Z = 90;

    public static void main(String[] args) {
        List<String> diamondArray = printDiamondWithUpperCaseAlphabet('Z');
//        System.out.println(diamondArray);
        diamondArray.forEach(System.out::println);

    }

    /**
     * Generates a diamond shape made of upper case alphabet letters up to the specified letter.
     *
     * <p>This method constructs a diamond pattern where the first row contains the letter 'A',
     * and each subsequent row contains the next letter of the alphabet, centered with spaces.
     * A
     * B B
     * A
     * The method requires an uppercase letter as input and will throw an exception if the input
     * is outside the range of 'A' to 'Z'. The resulting diamond is returned as a list of strings,
     * with each string representing a row of the diamond.</p>
     *
     * @param letter The upper case letter up to where the diamond is to be printed (inclusive).
     *               Must be between 'A' and 'Z'.
     * @return A list of strings representing the diamond shape.
     * @throws UnsupportedOperationException If the input letter is not an uppercase letter between 'A' and 'Z'.
     */

    public static List<String> printDiamondWithUpperCaseAlphabet(char letter) {
        if (letter < ASCI_NUM_A || letter > ASCI_NUM_Z) {
            throw new UnsupportedOperationException("Only inputs of upper cases letters a-z accepted.");
        }

        ArrayList<String> diamond = new ArrayList<>();

        int amountOfRows = letter - (ASCI_NUM_A - 1);
        int amountOfSpaces = amountOfRows * 2 - 1;

        StringBuilder spaces = createRowOfSpaces(amountOfSpaces);
        int locationOfa = (amountOfSpaces - 1) / 2;
        int offset = 1;
        for (int currentLetter = ASCI_NUM_A; currentLetter < ASCI_NUM_A + amountOfRows; currentLetter++) {
            StringBuilder stringBuilder = new StringBuilder(spaces);
            if (currentLetter == ASCI_NUM_A) {
                stringBuilder.setCharAt(locationOfa, (char) currentLetter);
            } else {
                stringBuilder.setCharAt(locationOfa - offset, (char) currentLetter);
                stringBuilder.setCharAt(locationOfa + offset, (char) currentLetter);
                offset++;
            }
            diamond.add(stringBuilder.toString());
        }
        return reverseListAndAppend(diamond);
    }

    /**
     * Creates a row of spaces for the diamond's layout.
     *
     * @param amountOfSpaces The number of spaces to generate.
     * @return A StringBuilder containing the specified number of spaces.
     */
    private static StringBuilder createRowOfSpaces(int amountOfSpaces) {
        StringBuilder spaces = new StringBuilder();
        for (int space = 0; space < amountOfSpaces; space++) {
            spaces.append(" ");
        }
        return spaces;
    }

    /**
     * Reverses the order of a list and appends it to the original list.
     *
     * <p>This method takes a list of strings, reverses it, removes the first element
     * (which is the middle row of the diamond), and appends the reversed list back to the original list
     * to create the diamond array.</p>
     *
     * @param list The original list of strings to be reversed and appended.
     * @return The updated list containing the original and reversed elements.
     */
    private static List<String> reverseListAndAppend(List<String> list) {
        List<String> temp = new ArrayList<>(list);
        Collections.reverse(temp);
        temp.remove(0);
        list.addAll(temp);
        return list;
    }
}
