package com.lab.lab1AnonymousRunnable;

import com.lab.lab1AnonymousRunnable.thread.MyThreadFirst;
import com.lab.lab1AnonymousRunnable.thread.MyThreadSecond;
import com.lab.lab1AnonymousRunnable.thread.ThreadThirdKahanSummation;

public class RunnerForL1 {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new MyThreadFirst(150));
        Thread threadTwo = new Thread(new MyThreadSecond(200));
        Thread threadThree = new Thread(new ThreadThirdKahanSummation(150));

        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
