package com.lab.lab5.thread;

import com.lab.exception.FillingRuntimeException;
import com.lab.lab5.ShowInformation;
import com.lab.util.FillingMatrixFromFile;
import com.lab.util.FillingVectorFromFile;

import java.io.IOException;
import java.util.concurrent.Callable;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class ThreadThirdKahanSummation implements Callable {
    private final int n;
    private final ShowInformation showInformation;

    public ThreadThirdKahanSummation(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }


    @Override
    public Object call() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformation.showMatrix(matrixResultA, "Thread Third finished. Time: " + first + " Millis" + " Result:");
        return matrixResultA;
    }


    public double[][] calculate() {
        double[] vectorD;
        double[] vectorB;
        double[][] matrixD;
        double[][] matrixT;
        double[][] matrixZ;
        double[][] matrixE;
        try {
            vectorD = FillingVectorFromFile.fillingVector(n, "");
            vectorB = FillingVectorFromFile.fillingVector(n, "");
            matrixD = FillingMatrixFromFile.fillingMatrix(n, "");
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
