package Chapter1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question1_7 {

    public static void rotate1(int [][] matrix){
        int last = matrix.length - 1;
        int length = matrix.length / 2;
        int tl, tr, br, bl, offset;
        for(int i = 0; i < length; i++){
            offset = 0;
            for(int j = i; j < last; j++){
                tl = matrix[i][j];
                tr = matrix[j][last];
                br = matrix[last][last - offset];
                bl = matrix[last-offset][i];

                matrix[i][j] = bl;
                matrix[j][last] = tl;
                matrix[last][last - offset] = tr;
                matrix[last-offset][i] = br;
                offset ++;
            }
            last--;
        }
    }

    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }


    public static void main(String[] args) {
        int[][] matrix = randomMatrix(3, 3, 0, 9);
        int[][] matrix1 = matrix;

        printMatrix(matrix);
        rotate(matrix);
        rotate1(matrix1);
        System.out.println();
        printMatrix(matrix);
        System.out.println();
        printMatrix(matrix1);

        Map<Integer, LinkedList> map = new HashMap<>();
        List<LinkedList> result4 = map.values().stream()
                .collect(Collectors.toList());

    }
}
