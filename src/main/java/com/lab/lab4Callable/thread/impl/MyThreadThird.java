package com.lab.lab4Callable.thread.impl;

import com.lab.exception.FillingRuntimeException;
import com.lab.lab4Callable.ShowInformationL4;
import com.lab.lab4Callable.thread.Calculate;
import com.lab.util.FillingMatrixFromFile;

import java.io.IOException;

import static com.lab.lab4Callable.OperationL4.*;
import static com.lab.lab4Callable.OperationL4.addTwoMatrix;

@SuppressWarnings("ALL")
public class MyThreadThird implements Calculate {
    private final int n;
    private final ShowInformationL4 showInformationL4;

    public MyThreadThird(int n, ShowInformationL4 showInformationL4) {
        this.n = n;
        this.showInformationL4 = showInformationL4;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultG[][] = calculate();


        long third = System.currentTimeMillis() - time;
        showInformationL4.showMatrix(matrixResultG, "Thread Second finished. Time: " + third + " Millis" + " Result:");
    }

    private double[][] calculate() {
        double[][] matrixB = randomMatrix(n);
        double[][] matrixO = randomMatrix(n);
        double[][] matrixC = randomMatrix(n);
        double[][] matrixX = randomMatrix(n);
        double[][] matrixM= randomMatrix(n);
        try {
            matrixB = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread ");
            matrixO = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
            matrixC = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
            matrixX = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
            matrixM = FillingMatrixFromFile.fillingMatrix(n, "Filling VectorB from file. It is Third thread");
        } catch (IOException e) {
            throw new FillingRuntimeException("Exception with Filling data!!!");
        }

        return addTwoMatrix(multiplyMatrix(matrixB, matrixO),
                multiplyMatrix(matrixC, subtractTwoMatrix(matrixX, matrixM)));
    }
}
