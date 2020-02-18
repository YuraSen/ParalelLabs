package com.lab.lab2Concurrent;

import com.lab.lab2Concurrent.thread.impl.MyThreadFirst;
import com.lab.lab2Concurrent.thread.impl.MyThreadSecond;
import com.lab.lab2Concurrent.thread.impl.MyThreadThird;

public class RunnerL2 {
    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
               new MyThreadFirst(6765).executeComputing();
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                 new MyThreadSecond(450).executeComputing();
            }
        });

        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                new MyThreadThird(499).executeComputing();
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();

    }
}
