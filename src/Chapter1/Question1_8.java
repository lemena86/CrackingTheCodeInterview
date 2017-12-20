package Chapter1;

public class Question1_8 {

    public static int[][] zeroMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return matrix; // Not a square
        int length = matrix.length;
        int rows[] = new int[length];
        int cols[] = new int[length];

        for (int row = 0; row < length; row++) {
            for(int col = 0; col<length; col++){
                if(matrix[row][col] == 0){
                    rows[row] = -1;
                    cols[col] = -1;
                }
            }
        }

        for(int i = 0; i < length; i++){
            if(rows[i] == -1) matrix[i] = new int[length];
        }
        for(int i = 0; i < length; i++){
            if(cols[i] == -1){
                for(int j = 0; j < length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] zeroMatrix1(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return matrix; // Not a square
        int length = matrix.length;
        int rows[] = new int[length];
        int cols[] = new int[length];

        for (int row = 0; row < length; row++) {
            for(int col = 0; col<length; col++){
                if(matrix[row][col] == 0){
                    rows[row] = -1;
                    cols[col] = -1;
                }
            }
        }

        for(int i = 0; i < length; i++){
            if(rows[i] == -1) matrix[i] = new int[length];
        }
        for(int i = 0; i < length; i++){
            if(cols[i] == -1){
                for(int j = 0; j < length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;
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
        printMatrix(matrix);
        zeroMatrix(matrix);
        System.out.println();
        printMatrix(matrix);
    }
}
