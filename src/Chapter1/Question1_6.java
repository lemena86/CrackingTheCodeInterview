package Chapter1;

public class Question1_6 {

    static String stringCompression(String s1){
        StringBuilder result = new StringBuilder();
        int length = s1.length();
        char previous = s1.charAt(0);
        result.append(previous);
        int count = 1;
        char actual;
        for(int i = 1; i < length; i++){
            actual = s1.charAt(i);
            if(previous == actual) count++;
            else{
                result.append(count);
                count = 1;
                previous = actual;
                result.append(previous);

            }
        }
        result.append(count);
        return result.length() < s1.length() ? result.toString() : s1;
    }


    public static void main(String[] args) {
        String str = "aaaaabbbbaaaabbddc";
        System.out.println(str);
        System.out.println(stringCompression(str));
    }
}
