package com.ray.java.interview.deadlock;

/**
 * Created by dangdang on 7/18/16.
 */
public class DLDriver {

    public static void main(String[] args) {
        DLThread1 thread1 = new DLThread1();
        DLThread2 thread2 = new DLThread2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thread1.a1(thread2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                thread2.b1(thread1);
            }
        }).start();
    }
}
