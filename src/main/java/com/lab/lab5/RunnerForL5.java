package com.lab.lab5;

import com.lab.lab5.thread.MyThreadFirst;
import com.lab.lab5.thread.MyThreadSecond;
import com.lab.lab5.thread.ThreadThirdKahanSummation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerForL5 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Lock lock = new ReentrantLock();
        ShowInformation showInformation = new ShowInformation(lock, semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Callable threadOne = new MyThreadFirst(150, showInformation);
        Callable threadTwo = new MyThreadSecond(200, showInformation);
        Callable threadThree = new ThreadThirdKahanSummation(150, showInformation);


        executorService.submit(threadOne);
        executorService.submit(threadTwo);
        executorService.submit(threadThree);

        executorService.shutdown();

    }
}
