package com.lab.lab5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class ShowInformation {
    private Lock locker;
    private Semaphore semaphore;

    public ShowInformation(Lock locker, Semaphore semaphore) {
        this.locker = locker;
        this.semaphore = semaphore;
    }
    public synchronized void showMatrix(double[][] matrix, String message) {
        try {
            semaphore.acquire();
            System.out.println("Lock showMatrix ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        showedMatrix(matrix, message);
        System.out.println();
        System.out.println("UnLock  showMatrix ");
        semaphore.release();
    }

    private static synchronized void showedMatrix(double[][] matrix, String message) {
        System.out.println(message);

        for (double[] matrix1 : matrix) {
            for (double v : matrix1) {
                System.out.print(v + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
