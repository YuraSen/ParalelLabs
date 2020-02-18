package com.lab.lab5.thread;

import com.lab.lab5.ShowInformation;

import java.util.concurrent.Callable;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class MyThreadSecond implements Callable {
    private final int n;
    private final ShowInformation showInformation;

    public MyThreadSecond(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }

    @Override
    public Object call() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double[] vectorResultC = calculate();

        long second = System.currentTimeMillis() - time;
        showVector(vectorResultC, "Thread Second finished. Time: " + second + " Millis" + " Result:");
        return vectorResultC;
    }

    private double[] calculate() {
        double[] vectorB = randomVector(n);
        double[] vectorD = randomVector(n);
        double[][] matrixT = randomMatrix(n);
        double[][] matrixX = randomMatrix(n);
        double numberA = randomNumber(n);

        return addTwoVector(multiplyVectorToMatrix(vectorB, matrixT),
                multiplyNumberToVector(numberA, multiplyVectorToMatrix(vectorD, matrixX)));
    }

}
