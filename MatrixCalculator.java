package Assignment2;

import java.util.*;

public class MatrixCalculator {

    // Read a matrix of given size
    static int[][] readMatrix(Scanner sc, int rows, int cols, String name) {
        int[][] M = new int[rows][cols];
        System.out.println("Enter elements of " + name + " (" + rows + "x" + cols + ") row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                M[i][j] = sc.nextInt();
            }
        }
        return M;
    }

    // Add two matrices
    static int[][] add(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        int[][] C = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    // Multiply two matrices
    static int[][] multiply(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length;
        int r2 = B.length, c2 = B[0].length;
        int[][] C = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    // Pretty print a matrix
    static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row) {
                System.out.printf("%6d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions for A
        System.out.print("Enter rows and columns of A (r1 c1): ");
        int r1 = sc.nextInt(), c1 = sc.nextInt();

        // Read dimensions for B
        System.out.print("Enter rows and columns of B (r2 c2): ");
        int r2 = sc.nextInt(), c2 = sc.nextInt();

        // Read matrices
        int[][] A = readMatrix(sc, r1, c1, "A");
        int[][] B = readMatrix(sc, r2, c2, "B");

        while (true) {
            System.out.println("\n--- Matrix Calculator ---");
            System.out.println("1. Add (A + B)");
            System.out.println("2. Multiply (A x B)");
            System.out.println("3. Print A and B");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (r1 == r2 && c1 == c2) {
                        int[][] C = add(A, B);
                        System.out.println("Result (A + B):");
                        printMatrix(C);
                    } else {
                        System.out.println("Addition not possible: dimensions must match (" +
                                r1 + "x" + c1 + " vs " + r2 + "x" + c2 + ").");
                    }
                    break;

                case 2:
                    if (c1 == r2) {
                        int[][] C = multiply(A, B);
                        System.out.println("Result (A x B):");
                        printMatrix(C);
                    } else {
                        System.out.println("Multiplication not possible: columns of A (" + c1 +
                                ") must equal rows of B (" + r2 + ").");
                    }
                    break;

                case 3:
                    System.out.println("Matrix A:");
                    printMatrix(A);
                    System.out.println("Matrix B:");
                    printMatrix(B);
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

