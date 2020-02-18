package com.lab.lab2Concurrent.thread.impl;

import com.lab.lab2Concurrent.thread.Calculate;

import static com.lab.util.OperationInMethods.*;

public class MyThreadThird implements Calculate {
    private final   int n;

    public MyThreadThird(int n) {
        this.n = n;

    }


    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showMatrix(matrixResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
    }

    private double[][] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorB = randomVector(n);
        double[][] matrixD = randomMatrix(n);
        double[][] matrixT = randomMatrix(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixE = randomMatrix(n);

        return multiplyNumberToMatrix(searchMinVector(addTwoVector(vectorD, vectorB)),
                addTwoMatrix(multiplyMatrixKohan(matrixD, matrixT), multiplyMatrixKohan(matrixZ, matrixE)));
    }
}
