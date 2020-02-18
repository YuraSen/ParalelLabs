package com.lab.lab3Concurrent.thread.impl;


import com.lab.lab3Concurrent.ShowInformationL3;
import com.lab.lab3Concurrent.thread.Calculate;

import static com.lab.util.OperationInMethods.*;

public class MyThreadFirst implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadFirst(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();


        long first = System.currentTimeMillis() - time;
        showInformationL3.showMatrix(matrixResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
    }

    private double[][] calculate() {
        double[] vectorD = randomVector(n);
        double[] vectorB = randomVector(n);
        double[][] matrixD = randomMatrix(n);
        double[][] matrixT = randomMatrix(n);
        double[][] matrixZ = randomMatrix(n);
        double[][] matrixE = randomMatrix(n);


        return multiplyNumberToMatrix(searchMinVector(addTwoVector(vectorD, vectorB)),
                addTwoMatrix(multiplyMatrix(matrixD, matrixT), multiplyMatrix(matrixZ, matrixE)));
    }
}
