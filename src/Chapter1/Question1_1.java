package Chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question1_1 {

    public static boolean isUnique(String word) {
        int length = word.length();
        Map<Character, Boolean> map = new HashMap();
        Character c;
        for (int i = 0; i < length; i++) {
            c = word.charAt(i);
            if (map.get(c) != null) return false;
            map.put(c, true);
        }
        return true;
    }

    public static boolean isUnique1(String word) {
        int length = word.length();
        char[] array = word.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < length - 1; i++) {
            if (array[i] == array[i + 1]) return false;
        }
        return true;
    }

    public static boolean isUnique2(String word) {
        // ascii has 128, 256 extended
        if (word.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i);
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    static boolean isUnique3(String word) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (word.indexOf(letter, i + 1) != -1) {
                return false;
            }
        }
        return true;
    }

    /* Assumes only letters a through z. */
    public static boolean isUnique4(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

}