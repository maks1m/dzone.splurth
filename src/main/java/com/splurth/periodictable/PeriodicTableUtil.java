package com.splurth.periodictable;

public class PeriodicTableUtil {

    /**
     * All chemical symbols must be exactly two letters.
     * <p>Both letters in the symbol must appear in the element name, but the first letter of the element name does not
     * necessarily need to appear in the symbol.
     * <p>The two letters must appear in order in the element name. So Vr is valid for Silver, but Rv is not.
     * <p>To be clear, both Ma and Am are valid for Magnesium, because there is both an a that appears after an m,
     * and an m that appears after an a
     */
    public static boolean isChemicalSymbolCorrect(String element, String symbol) {
        if (element == null || symbol == null || symbol.length() != 2) {
            return false;
        }
        int symbol1Position = -1;
        int symbol2Position = -1;
        char symbol1 = (char) (symbol.charAt(0) | 96); // to lower case using bitwise operator
        char symbol2 = (char) (symbol.charAt(1) | 96);

        for (int i = 0; i < element.length(); i++) {
            char letter = (char) (element.charAt(i) | 96);
            if (symbol1Position == -1 && letter == symbol1) {
                symbol1Position = i;
            }
            if (letter == symbol2) {
                symbol2Position = i;
            }
        }
        return symbol2Position > -1 && symbol1Position < symbol2Position;
    }

    /**
     * Find the valid symbol for that name that's first in alphabetical order. E.g.Gozerium -> Ei, Slimyrine -> Ie.
     */
    public static String getValidSymbol(String elementName) {
        if (elementName == null || elementName.length() < 3) {
            return "";
        }

        char letter1 = (char) (elementName.charAt(0) | 96);
        char letter2 = (char) (elementName.charAt(1) | 96);

        for (int i = 1; i < elementName.length(); i++) {
            char letter = (char) (elementName.charAt(i) | 96);
            if (letter < letter1 && i < elementName.length() - 1) {
                letter1 = letter;
                letter2 = elementName.charAt(i + 1);
                continue;
            }
            if (letter < letter2) {
                letter2 = letter;
            }
        }
        String result = new String(new char[]{(char) (letter1 - 32), letter2});
        System.out.println(result);
        return result;
    }

    // Given an element name, find the number of distinct valid symbols for that name. E.g. Zuulon -> 11.
    public static int getNumberOfDistinctSymbols(String elementName) {
        return 0;
    }

}
