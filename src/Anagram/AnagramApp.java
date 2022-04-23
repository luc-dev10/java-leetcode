package Anagram;

import java.util.Arrays;

public class AnagramApp {
    public static void main(String[] args) {

        String firstWord = "Earth";
        String secondWord = "thEsr";
        System.out.printf("Is Earth and thEar an anagram: %b%n", isAnagram(firstWord, secondWord));
    }

    public static boolean isAnagram(String firstWord, String secondWord) {

        if (firstWord == null || secondWord == null || firstWord.length() != secondWord.length())
            return false;

        char[] firstWordChars = firstWord.toLowerCase()
                                         .toCharArray();
        char[] secondWordChars = secondWord.toLowerCase()
                                           .toCharArray();

        // sort characters before loop
        Arrays.sort(firstWordChars);
        Arrays.sort(secondWordChars);

        return Arrays.equals(firstWordChars, secondWordChars);

    }
}
