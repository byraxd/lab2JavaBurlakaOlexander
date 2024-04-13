package org.example;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше 20): ");
        int width = scanner.nextInt();

        System.out.print("Введіть висоту матриці (не більше 20): ");
        int height = scanner.nextInt();

        if (width > 20 || height > 20) {
            System.out.println("Помилка: Розмір матриці перевищує 20 на 20");
            return;
        }

        int[][] matrix = createRandomMatrix(width, height);
        printMatrix(matrix);
        System.out.println("Мін значення: " + findMin(matrix));
        System.out.println("Макс значення: " + findMax(matrix));
        System.out.println("Середнє значення: " + calculateAverage(matrix));
    }

    public static int[][] createRandomMatrix(int width, int height) {
        int[][] matrix = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = (int) (Math.random() * 10); // Випадкове число від 0 до 9
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return (double) sum / count;
    }
}
