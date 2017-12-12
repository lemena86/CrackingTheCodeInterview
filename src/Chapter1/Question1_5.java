package Chapter1;

import java.util.HashMap;
import java.util.Map;

public class Question1_5 {

    static boolean oneAway(String a, String b) {
        if (b.length() > a.length() + 1) return false; //more than one insert
        if (b.length() < a.length() - 1) return false; //more than one delete

        int count = 0;
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) count++;
                if (count > 1) return false;

            }
        } else {
            String min, max;
            if (a.length() < b.length()) {
                min = a;
                max = b;
            } else {
                min = b;
                max = a;
            }

            for (int i = 0, j = 0; i < min.length(); ) {
                if (min.charAt(i) == max.charAt(j)) {
                    i++;
                    j++;
                    continue;
                }
                j++;
                count++;
                if (count > 1) return false;
            }
        }
        return true;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway1(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }
    public static boolean oneEditAway2(String first, String second) {
		/* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

		/* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = oneEditAway2(a, b);
        boolean resultB = oneAway(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }



    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }
    }
}
