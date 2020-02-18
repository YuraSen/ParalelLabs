package com.lab.lab2Concurrent.thread.impl;

import com.lab.lab2Concurrent.thread.Calculate;

import static com.lab.util.OperationInMethods.*;

public class MyThreadSecond implements Calculate {
    private final  int n;

    public MyThreadSecond(int n) {
        this.n = n;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double[] vectorResultC = calculate();

        long second = System.currentTimeMillis() - time;
        showVector(vectorResultC, "Thread Second finished. Time: " + second + " Millis" + " Result:");

    }

    private double[] calculate() {
        double[] vectorB = randomVector(n);
        double[] vectorD = randomVector(n);
        double[][] matrixT= randomMatrix(n);
        double[][] matrixX = randomMatrix(n);
        double numberA = randomNumber(n);

        return addTwoVector(multiplyVectorToMatrix(vectorB, matrixT),
                multiplyNumberToVector(numberA, multiplyVectorToMatrix(vectorD, matrixX)));
    }
}
