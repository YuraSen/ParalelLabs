package com.lab.lab4Callable.thread.impl;

import com.lab.lab4Callable.ShowInformationL4;
import com.lab.lab4Callable.thread.Calculate;
import com.lab.util.OperationInMethods;

import static com.lab.lab4Callable.OperationL4.*;


public class MyThreadFirst implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadFirst(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformationL4.showMatrix(matrixResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
    }

    private double[][] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorB = randomVector(n);
        double[][] matrixD = randomMatrix(n);
        double[][] matrixT = randomMatrix(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixE = randomMatrix(n);


        return multiplyNumberToMatrix(searchMinVector(addTwoVector(vectorD, vectorB)),
                OperationInMethods.addTwoMatrix(multiplyMatrix(matrixD, matrixT), multiplyMatrix(matrixZ, matrixE)));

    }
}
