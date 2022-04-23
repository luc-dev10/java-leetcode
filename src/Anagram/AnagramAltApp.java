package Anagram;

import java.util.Arrays;

public class AnagramAltApp {
    public static void main(String[] args) {
        String firstWord = "Earth";
        String secondWord = "thEar";
        System.out.printf("Is Earth and thEar an anagram: %b%n", isAnagram(firstWord, secondWord));
    }

    // return sorted characters
    private static char[] convertToArrayList(String word) {

        if (word == null)
            return null;

        char[] chars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            // lower case characters
            c = c >= 'A' && c <= 'Z' ? (char) (c + ('a' - 'A')) : c;
            chars[i] = c;
        }

        // start sorting characters
        selectionSort(chars);

        return chars;
    }

    private static void selectionSort(char[] chars) {

        for (int i = 0; i < chars.length; i++) {

            int indexOfLowest = i;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] < chars[indexOfLowest])
                    indexOfLowest = j;
            }

            if (i != indexOfLowest) {
                char temp = chars[i];
                chars[i] = chars[indexOfLowest];
                chars[indexOfLowest] = temp;
            }

        }

    }

    public static boolean isAnagram(String firstWord, String secondWord) {

        if (firstWord == null || secondWord == null || firstWord.length() != secondWord.length())
            return false;

        char[] firstWordChars = convertToArrayList(firstWord);
        char[] secondWordChars = convertToArrayList(secondWord);

        // sort characters before loop
        Arrays.sort(firstWordChars);
        Arrays.sort(secondWordChars);

        for (int i = 0; i < firstWordChars.length; i++)
            if (firstWordChars[i] != secondWordChars[i])
                return false;

        return true;

    }
}
