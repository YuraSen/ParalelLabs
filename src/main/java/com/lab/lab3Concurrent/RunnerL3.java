package com.lab.lab3Concurrent;


import com.lab.lab3Concurrent.thread.impl.MyThreadFirst;
import com.lab.lab3Concurrent.thread.impl.MyThreadSecond;
import com.lab.lab3Concurrent.thread.impl.MyThreadThird;

import java.util.concurrent.Semaphore;

public class RunnerL3 {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        ShowInformationL3 show = new ShowInformationL3(semaphore);

        Runnable thread1 = new MyThreadFirst(1200, show)::executeComputing;

        Runnable thread2 = new MyThreadSecond(990, show)::executeComputing;

        Runnable thread3 = new MyThreadThird(499, show)::executeComputing;


        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();
    }
}
