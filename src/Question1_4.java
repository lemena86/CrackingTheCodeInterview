import java.util.HashMap;
import java.util.Map;

public class Question1_4 {

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome1(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    /* Toggle the ith bit in the integer. */
    public static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /* Create bit vector for string. For each letter with value i,
     * toggle the ith bit. */
    public static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /* Check that exactly one bit is set by subtracting one from the
     * integer and ANDing it with the original integer. */
    public static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPermutationOfPalindrome3(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }


    /************/

    static boolean isPalindrome(String str) {
        int j = str.length() - 1, i = 0;
        while (j > i) {
            if (str.charAt(i) != str.charAt(j)) return false;
            j--;
            i++;
        }
        return true;
    }

    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    static boolean palindromePermutation(String str) {
        if (str.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        boolean odd = false;
        int possibleOdd = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) > 'a' && str.charAt(i) < 'z') {
                odd = !odd;
                if (map.get(str.charAt(i)) == null) {
                    map.put(str.charAt(i), 1);
                    possibleOdd++;
                } else {
                    int v = map.get(str.charAt(i));
                    if (v % 2 == 0) possibleOdd++;
                    else possibleOdd--;
                    map.put(str.charAt(i), v + 1);
                }
            }
        }
        if (odd) {
            if (possibleOdd > 1) return false;
        } else {
            if (possibleOdd > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"};
        for (String s : strings) {
            boolean a = isPermutationOfPalindrome1(s);
            boolean b = isPermutationOfPalindrome2(s);
            boolean c = isPermutationOfPalindrome3(s);
            boolean d = palindromePermutation(s);
            System.out.println(s);
            if (a == b && b == c && c == d) {
                System.out.println("Agree: " + a);
            } else {
                System.out.println("Disagree: " + a + ", " + b + ", " + c + ", "+d);
            }
            System.out.println();

        }
    }
}
