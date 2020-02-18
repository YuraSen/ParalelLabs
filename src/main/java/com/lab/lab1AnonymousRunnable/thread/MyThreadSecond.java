package com.lab.lab1AnonymousRunnable.thread;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class MyThreadSecond implements Runnable {
    private final  int n;

    public MyThreadSecond(int n) {
        this.n = n;
    }

    @Override
    public void run() {
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
