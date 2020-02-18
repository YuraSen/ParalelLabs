package com.lab.lab3Concurrent.thread.impl;

import com.lab.lab3Concurrent.ShowInformationL3;
import com.lab.lab3Concurrent.thread.Calculate;

import static com.lab.util.OperationInMethods.*;

public class MyThreadSecond implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadSecond(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double[] vectorResultC = calculate();


        long second = System.currentTimeMillis() - time;
        showInformationL3.showVector(vectorResultC, "Thread Second finished. Time: " + second + " Millis" + " Result:");

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
