package Chapter1;

public class Question1_6 {

    static String stringCompression(String word) {
        StringBuilder builder = new StringBuilder();
        Character letter1;
        int count;
        for (int i = 0, length = word.length(); i < length; ) {
            letter1 = word.charAt(i);
            count = 1;
            while (++i < length && letter1 == word.charAt(i)) count++;
            builder.append(letter1 + "" + count);
        }
        return builder.toString().length() < word.length() ? builder.toString() : word;
    }

    public static String compress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

			/* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

			/* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }


    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddc";
        System.out.println(str);
        System.out.println(stringCompression(str));
        System.out.println(compress(str));
    }
}
