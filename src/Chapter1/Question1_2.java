package Chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mena on 06-12-17.
 */
public class Question1_2 {
    static Map<Character, Integer> wordToMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
                continue;
            }
            map.put(letter, 1);

        }
        return map;
    }

    /**
     * O(n)
     *
     * @param a
     * @param b
     * @return
     */
    static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) return false;
        Map<Character, Integer> map = wordToMap(a);
        for (int i = 0; i < b.length(); i++) {
            char letter = b.charAt(i);
            if (!map.containsKey(letter) || map.get(letter) == 0) {
                return false;
            }
            map.put(letter, map.get(letter) - 1);
        }
        return true;
    }

    static String sortString(String word) {
        char[] chArray = word.toCharArray();
        Arrays.sort(chArray);
        return new String(chArray);
    }

    /**
     * O(n log n)
     *
     * @param a
     * @param b
     * @return
     */
    static boolean isPermutation1(String a, String b) {
        if (a.length() != b.length()) return false;
        return sortString(a).equals(sortString(b));
    }

    static boolean isPermutation2(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation1(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = isPermutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
