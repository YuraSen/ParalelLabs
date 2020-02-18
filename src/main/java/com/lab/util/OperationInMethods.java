package com.lab.util;

import java.util.Arrays;
import java.util.Comparator;

public class OperationInMethods {

    private static double algoritmKohan(double[] flt_arr)
    {
        double sum, correction, corrected_next_term, new_sum;

        sum = flt_arr[0];
        correction = 0.0;
        for (int i = 1; i < flt_arr.length; i++)
        {
            corrected_next_term = flt_arr[i] - correction;
            new_sum = sum + corrected_next_term;
            correction = (new_sum - sum) - corrected_next_term;
            sum = new_sum;
        }
        return sum;
    }

    public static double[] addTwoVector(double vectorFirst[], double vectorSecond[]) {
        for (int i = 0; i < vectorSecond.length; i++) {
            vectorFirst[i] += vectorSecond[i];
        }

        return vectorFirst;
    }

    public static double[] subtractTwoVector(double vectorFirst[], double vectorSecond[]) {
        for (int i = 0; i < vectorSecond.length; i++) {
            vectorFirst[i] -= vectorSecond[i];
        }

        return vectorFirst;
    }

    public static double[][] multiplyMatrixKohan(double[][] firstMatrix, double[][] secondMatrix) {
        double[] temp = new double[firstMatrix.length];
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    temp[k] =  firstMatrix[i][k] * secondMatrix[k][j];
                }
                resultMatrix[i][j] = algoritmKohan(temp);

            }
        }

        return resultMatrix;
    }

    public static double[] multiplyVectorToMatrixKohan(double[] vectorFirst, double[][] matrixSecond) {
        double[] resultVector = new double[vectorFirst.length];
        double[] temp = new double[vectorFirst.length];
        for (int i = 0; i < matrixSecond.length; i++) {
            for (int j = 0; j < resultVector.length; j++) {
                temp[j] = vectorFirst[j] * matrixSecond[j][i];
            }
            resultVector[i] += algoritmKohan(temp);
        }

        return resultVector;
    }

    public static double[][] multiplyMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }

            }
        }

        return resultMatrix;
    }

    public static double[][] addTwoMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];

            }
        }

        return resultMatrix;
    }

    public static double[][] subtractTwoMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];

            }
        }

        return resultMatrix;
    }

    public static double[] multiplyVectorToMatrix(double vectorFirst[], double matrixSecond[][]) {
        double resultVector[] = new double[vectorFirst.length];

        for (int i = 0; i < matrixSecond.length; i++) {
            for (int j = 0; j < resultVector.length; j++) {
                resultVector[i] += vectorFirst[j] * matrixSecond[j][i];
            }
        }

        return resultVector;
    }

    public static double[][] randomMatrix(int n) {
        double matrix[][] = new double[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 1;
            }
        }

        return matrix;
    }

    public static double[] randomVector(int n) {
        double vector[] = new double[n];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 1;
        }

        return vector;
    }

    public static double randomNumber(int n) {
        double number = n;
        for (int i = 0; i < n; i++) {
            number = 1;
        }

        return number;
    }

    public static synchronized void showVector(double vector[], String message) {
        System.out.println(message);
        for (double aVector : vector) {
            System.out.print(aVector + " ");
        }
        System.out.println();
    }

    public static synchronized void showNumber(double number, String message) {
        System.out.println(message);
        for (int i = 0; i < number; i++) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static synchronized void showMatrix(double matrix[][], String message) {
        System.out.println(message);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static double searchMinVector(double[] vector) {
        return Arrays.stream(vector)
                .min().getAsDouble();
    }

    public static double[] multiplyNumberToVector(double number, double vector[]) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * number;
        }

        return vector;
    }

    public static double[] multiplyVectorToVector(double vectorFirst[], double vectorSecond[]) {
        double[] resultVector = new double[vectorFirst.length];
        for (int i = 0; i < vectorSecond.length; i++) {
            resultVector[i] = vectorFirst[i] * vectorSecond[i];
        }

        return resultVector;
    }

    public static double[][] multiplyNumberToMatrix(double number, double[][] firstMatrix) {
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[1].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                resultMatrix[i][j] = number * firstMatrix[i][j];

            }
        }

        return resultMatrix;
    }

    public static double[] sortVector(double[] vector) {
        Arrays.sort(vector);
        return vector;
    }
}
