package Chapter10;

/**
 * Created by nisum on 1/22/18.
 */
public class Question1 {

    public static void merge(int[] array1, int[] array2) {
        int index = array1.length - 1;
        for (int i = 0; i < array2.length; i++) {
            array1[index--] = array2[i];
        }
        util.MergeSort.mergesort(array1);
    }

    public static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
        int indexA = lastA - 1; /* Index of last element in array b */
        int indexB = lastB - 1; /* Index of last element in array a */

		/* Merge a and b, starting from the last element in each */
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 4, 8, 11, 12, 18, 20, 21, 0, 0 , 0 , 0};
        int[] array2 = {2, 7, 17, 22};
        for (int i : array1) {
            System.out.print(i+" ");
        }
        System.out.println("-------");
        //merge(array1, array2);
        merge(array1, array2, 8, 4);
        for (int i : array1) {
            System.out.print(i+" ");
        }
    }

}
