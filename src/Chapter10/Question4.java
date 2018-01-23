package Chapter10;


public class Question4 {

    public static int search(int[] array, int value) {
        int index = 1;
        while (array[index] > -1 && array[index] < value) {
            index *= 2;
        }

        return binarySearch(array, value, 0, index);
    }

    public static int binarySearch(int[] array, int value, int left, int right) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value || array[middle] == -1) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        int[] a = {1, 2, 3, 4,6,7,8,23,35,67,78,99, 123, 213, 12312, 455646, 2131231231, -1,-1,-1,-1,-1,-1,-1,-1};
        System.out.println(search(a, 99));
    }
}
