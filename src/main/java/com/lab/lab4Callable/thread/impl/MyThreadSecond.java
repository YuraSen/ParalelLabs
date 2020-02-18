package com.lab.lab4Callable.thread.impl;

import com.lab.lab4Callable.ShowInformationL4;
import com.lab.lab4Callable.thread.Calculate;

import static com.lab.lab4Callable.OperationL4.*;
import static com.lab.util.OperationInMethods.randomNumber;

@SuppressWarnings("ALL")
public class MyThreadSecond implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadSecond(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double[] vectorResultC = calculate();

        long second = System.currentTimeMillis() - time;
        showInformationL4.showVector(vectorResultC, "Thread Second finished. Time: " + second + " Millis" + " Result:");

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
