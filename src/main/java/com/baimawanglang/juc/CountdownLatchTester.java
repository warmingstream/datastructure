package com.baimawanglang.juc;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTester {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread1 = new Thread(new MyThread(latch, 1000));
        Thread thread2 = new Thread(new MyThread(latch, 5000));
        thread1.start();
        thread2.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all finished");
    }
}


class MyThread implements Runnable {
    private CountDownLatch latch;
    private long time;

    MyThread(CountDownLatch latch, long time) {
        this.latch = latch;
        this.time = time;
    }

    public void run() {
        try {
            Thread.sleep(time);
            System.out.println("Thread 1 is finished");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
