package Chapter10;


public class Question5 {

    public static int binarySearch(String[] array, String x, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle].equals(x)) {
            return middle;
        } else if (array[middle].equals("")) {
            int r = binarySearch(array, x, left, middle - 1);
            if (r == -1) {
                return binarySearch(array, x, middle + 1, right);
            }
            return r;
        } else if (array[middle].compareTo(x) == -1) {
            return binarySearch(array, x, left, middle - 1);
        } else {
            return binarySearch(array, x, middle + 1, right);
        }
    }

    public static int search(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

		/* Move mid to the middle */
        int mid = (last + first) / 2;

		/* If mid is empty, find closest non-empty string. */
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

		/* Check for string, and recurse if necessary */
        if (str.equals(strings[mid])) { // Found it!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return search(strings, str, mid + 1, last);
        } else { // Search left
            return search(strings, str, first, mid - 1);
        }
    }

    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    public static void main(String[] args) {
        String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(binarySearch(array, "car", 0, array.length - 1));

        System.out.println(search(array, "ball"));
    }
}
