package com.lab.lab5.thread;

import com.lab.exception.FillingRuntimeException;
import com.lab.lab5.ShowInformation;
import com.lab.util.FillingMatrixFromFile;
import com.lab.util.FillingVectorFromFile;

import java.io.IOException;
import java.util.concurrent.Callable;

import static com.lab.util.OperationInMethods.*;

@SuppressWarnings("ALL")
public class MyThreadFirst implements Callable {
    private final  int n;
    private final ShowInformation showInformation;

    public MyThreadFirst(int n, ShowInformation showInformation) {
        this.n = n;
        this.showInformation = showInformation;
    }


@Override
    public Object call() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultA[][] = calculate();

        long first = System.currentTimeMillis() - time;
        showInformation.showMatrix(matrixResultA, "Thread First finished. Time: " + first + " Millis" + " Result:");
        return matrixResultA;
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
