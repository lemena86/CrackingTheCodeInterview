package Chapter1;

import java.util.HashMap;
import java.util.Map;

public class Question1_1 {

    static boolean allUnique(String word) {
        Map<Character, Boolean> letters = new HashMap();
        for (int i = 0; i < word.length(); i++) {
            char l = word.charAt(i);
            if (letters.containsKey(l)) return false;
            letters.put(l, true);
        }
        return true;
    }

    static boolean allUnique1(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (word.indexOf(letter, i+1) != -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA =  allUnique(word);
            boolean wordB =  allUnique1(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }

    }
}