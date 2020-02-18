package com.lab.lab3Concurrent;

import java.util.concurrent.Semaphore;

public class ShowInformationL3 {
    private final Semaphore semaphore;

    public ShowInformationL3(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public synchronized void showVector(double vector[], String message) {
        try {
            semaphore.acquire();
            System.out.println("Lock showVector ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
        for (double aVector : vector) {
            System.out.print(aVector + " ");
        }
        System.out.println();
        System.out.println("UnLock  showVector ");
        semaphore.release();

    }

    public synchronized void showMatrix(double[][] matrix, String message) {
        try {
            semaphore.acquire();
            System.out.println("Lock showMatrix ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
        for (double[] aMatrix : matrix) {
            System.out.print(aMatrix + " ");
        }
        System.out.println();
        System.out.println("UnLock  showVector ");
        semaphore.release();

    }
}
