package Anagram;

import java.util.ArrayList;

public class AnagramSlowApp {

    public static void main(String[] args) {
        String firstWord = "Earth";
        String secondWord = "thEar";
        System.out.printf("Is Earth and thEar an anagram: %b%n", isAnagram(firstWord, secondWord));

    }

    public static boolean isAnagram(String firstWord, String secondWord) {

        if (firstWord == null || secondWord == null || firstWord.length() != secondWord.length())
            return false;

        // convert second word into list
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < secondWord.length(); i++)
            characters.add(secondWord.charAt(i));

        // go through all characters of first word
        for (int i = 0; i < firstWord.length(); i++) {
            char c = firstWord.charAt(i);
            if (characters.contains(c))
                characters.remove(Character.valueOf(c));
            else
                return false;
        }

        return characters.size() == 0;
    }
}
