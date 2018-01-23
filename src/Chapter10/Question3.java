package Chapter10;

/**
 * Created by nisum on 1/23/18.
 */
public class Question3 {

    public static int search(int[] array, int value, int left, int rigth) {
        int middle = (left + rigth) / 2;
        if (rigth < left) {
            return -1;
        }

        if (array[middle] == value) {
            return middle;
        } else if (array[left] < array[middle]) {
            if (value >= array[left] && value < array[middle]) {
                return search(array, value, left, middle - 1);
            } else {
                return search(array, value, middle + 1, rigth);
            }
        } else if (array[rigth] > array[middle]) {
            if (value > array[middle] && value <= array[rigth]) {
                return search(array, value, middle + 1, rigth);
            } else {
                return search(array, value, left, middle - 1);
            }
        } else if (array[left] == array[middle]) {
            if (array[middle] != array[rigth]) {
                return search(array, value, middle + 1, rigth);
            } else {
                int result = search(array, value, left, middle - 1);
                if (result == -1) {
                    return search(array, value, middle + 1, rigth);
                }
                return result;
            }
        }

        return -1;
    }


    public static void main(String ...args){
        int [] array = {10,15,20,0,5};
        int [] array1 = {50,5,20,30,40};
        int [] array2 = {2,2,2,3,4,2};

        System.out.println(search(array,5,0,array.length-1));
        System.out.println(search(array1,5,0,array.length-1));
        System.out.println(search(array2,4,0,array.length-1));
    }
}
