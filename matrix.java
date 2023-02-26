import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<0) {
            System.out.println("Spiral is not possible of negative values");
            return;
        }
        printMatrix(createSpiralMatrix(n));     // both function call
        sc.close();
    }

    public static int[][] createSpiralMatrix(int n) {
        int val = 1, topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int[][] matrix = new int[n][n];
        while (val <= n * n) {
            // fill top row from left to right
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[topRow][i] = val++;
            }
            topRow++;
            // fill right column from top to bottom
            for (int i = topRow; i <= bottomRow; i++) {
                matrix[i][rightCol] = val++;
            }
            rightCol--;
            // fill bottom row from right to left
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    matrix[bottomRow][i] = val++;
                }
                bottomRow--;
            }
            // fill left column from bottom to top
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    matrix[i][leftCol] = val++;
                }
                leftCol++;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int j : arr) {
                String temp = Integer.toString(j);
                if (temp.length()==1) {
                    System.out.print(j + "    ");
                }
                else if (temp.length()==2) {
                    System.out.print(j + "   ");
                }
                else if (temp.length()==3) {
                    System.out.print(j + "  ");
                }
                else if (temp.length()==4) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
