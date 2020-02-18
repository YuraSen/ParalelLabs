package com.lab.lab4Callable;

import com.lab.lab4Callable.thread.impl.MyThreadFirst;
import com.lab.lab4Callable.thread.impl.MyThreadSecond;
import com.lab.lab4Callable.thread.impl.MyThreadThird;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class RunnerL4 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ShowInformationL4 show = new ShowInformationL4(semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable task1= new MyThreadFirst(5453, show)::executeComputing;
        Runnable task2=(new MyThreadSecond(3000, show)::executeComputing);
        Runnable task3=(new MyThreadThird(700,show)::executeComputing);

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }

}
