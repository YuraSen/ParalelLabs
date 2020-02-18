package com.lab.lab1AnonymousRunnable.thread;

import com.lab.exception.FillingRuntimeException;
import com.lab.util.FillingMatrixFromFile;
import com.lab.util.FillingVectorFromFile;

import java.io.IOException;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class MyThreadFirst implements Runnable {
    private final  int n;

    public MyThreadFirst(int n) {
        this.n = n;
    }



    @Override
    public void run() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showMatrix(matrixResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
    }



    public double[][] calculate() {

        double[] vectorD = new double[0];
        double[] vectorB = new double[0];
        double[][] matrixD = new double[0][];
        double[][] matrixT = new double[0][];
        double[][] matrixZ = new double[0][];
        double[][] matrixE = new double[0][];
        try {
            vectorD = FillingVectorFromFile.fillingVector(n,"");
            vectorB = FillingVectorFromFile.fillingVector(n,"");
            matrixD = FillingMatrixFromFile.fillingMatrix(n,"");
            matrixT = FillingMatrixFromFile.fillingMatrix(n, "");
            matrixZ = FillingMatrixFromFile.fillingMatrix(n, "");
            matrixE = FillingMatrixFromFile.fillingMatrix(n, "");
        } catch (IOException e) {
            throw new FillingRuntimeException();
        }


        return multiplyNumberToMatrix(searchMinVector(addTwoVector(vectorD, vectorB)),
                addTwoMatrix(multiplyMatrix(matrixD, matrixT), multiplyMatrix(matrixZ, matrixE)));



    }
}
