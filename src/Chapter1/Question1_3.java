package Chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mena on 06-12-17.
 */
public class Question1_3 {

    static String replaceWhiteSpaces(String word, int trueLength) {
        char[] array = word.toCharArray();
        for (int i = trueLength - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                 for (int j = array.length - 1; j > i + 2; j--) {
                    array[j] = array[j - 2];
                 }
                array[i] = '%';
                array[i + 1] = '2';
                array[i + 2] = '0';
            }

        }
        return new String(array);
    }

    public static String replaceSpaces(String stri, int trueLength) {
        char[]str = stri.toCharArray();
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return new String(str);
    }


    public static void main(String[] args) {
        String word = "Mr John Smith    ";
        int trueLength = 13;
        System.out.println(replaceSpaces(word, trueLength));
        System.out.println(replaceWhiteSpaces(word, trueLength));
    }
}
