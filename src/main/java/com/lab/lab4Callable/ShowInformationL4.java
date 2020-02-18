package com.lab.lab4Callable;

import java.util.concurrent.Semaphore;

@SuppressWarnings("ALL")
public class ShowInformationL4 {
    private final Semaphore semaphore;

    public ShowInformationL4(Semaphore semaphore) {
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
