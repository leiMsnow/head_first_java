package com.ray.java.data.structure.simple_thread;

/**
 * Created by dangdang on 5/17/16.
 */
public class TestSync implements Runnable {

    private int balance;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("balance is " + balance);
        }
    }

    private synchronized void increment() {
        int i = balance;
        balance = i + 1;
    }

    public static void main(String[] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }

}

