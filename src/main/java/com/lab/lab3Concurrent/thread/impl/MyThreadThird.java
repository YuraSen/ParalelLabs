package com.lab.lab3Concurrent.thread.impl;

import com.lab.exception.FillingRuntimeException;
import com.lab.lab3Concurrent.ShowInformationL3;
import com.lab.lab3Concurrent.thread.Calculate;
import com.lab.util.FillingMatrixFromFile;

import java.io.IOException;

import static com.lab.lab3Concurrent.OperationLab3.*;
import static com.lab.util.OperationInMethods.subtractTwoMatrix;

@SuppressWarnings("ALL")
public class MyThreadThird implements Calculate {
    private final int n;
    private final ShowInformationL3 showInformationL3;

    public MyThreadThird(int n, ShowInformationL3 showInformationL3) {
        this.n = n;
        this.showInformationL3 = showInformationL3;
    }

    @Override
    public void executeComputing() {
        long time = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " start");

        double matrixResultG[][] = calculate();

        long third = System.currentTimeMillis() - time;
        showInformationL3.showMatrix(matrixResultG, "Thread Second finished. Time: " + third + " Millis" + " Result:");
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
