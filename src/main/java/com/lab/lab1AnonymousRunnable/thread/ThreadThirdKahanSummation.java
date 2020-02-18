package com.lab.lab1AnonymousRunnable.thread;

import com.lab.exception.FillingRuntimeException;
import com.lab.util.FillingMatrixFromFile;
import com.lab.util.FillingVectorFromFile;

import java.io.IOException;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class ThreadThirdKahanSummation implements Runnable {
    private final  int n;

    public ThreadThirdKahanSummation(int n) {
        this.n = n;
    }



    @Override
    public void run() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showMatrix(matrixResultA, "Thread Third finished. Time: " + first + " Millis" + " Result:");
    }



    public double[][] calculate() {
        double[] vectorD;
        double[] vectorB;
        double[][] matrixD;
        double[][] matrixT;
        double[][] matrixZ;
        double[][] matrixE;
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
                addTwoMatrix(multiplyMatrixKohan(matrixD, matrixT), multiplyMatrixKohan(matrixZ, matrixE)));



    }
}
