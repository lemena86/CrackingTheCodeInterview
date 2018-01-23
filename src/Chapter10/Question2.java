package Chapter10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nisum on 1/22/18.
 */
public class Question2 {
    public static String[] sort(String[] array) {
        int length = array.length;
        String[] newArray = new String[length];
        int index = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.get(i) == null) {
                newArray[index++] = array[i];
                map.put(i, true);
                for (int j = i + 1; j < length; j++) {
                    if (isAnagram(array[i], array[j])) {
                        map.put(j, true);
                        newArray[index++] = array[j];
                    }
                }
            }
        }
        return newArray;
    }

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        Arrays.sort(aa);
        Arrays.sort(bb);
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] != bb[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(util.AssortedMethods.stringArrayToString(array));
        String[] r = sort(array);
        System.out.println(util.AssortedMethods.stringArrayToString(r));

        Arrays.sort(array, new AnagramComparator());
        System.out.println(util.AssortedMethods.stringArrayToString(array));
    }
}
