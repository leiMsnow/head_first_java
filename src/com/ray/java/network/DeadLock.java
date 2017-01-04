package com.ray.java.network;

/**
 * Created by dangdang on 29/12/2016.
 */
public class DeadLock {
    public static final String res1 = "res1";
    public static final String res2 = "res2";

    public static void main(String[] args) {

        Thread lock1 = new Thread(new Lock1());
        lock1.start();

        Thread lock2 = new Thread(new Lock2());
        lock2.start();
    }


    static class Lock1 implements Runnable {

        @Override
        public void run() {
            synchronized (DeadLock.res1) {
                System.out.println("thread-1 locked res1");
                try {
                    Thread.sleep(300);
                    synchronized (DeadLock.res2) {
                        System.out.println("thread-1 locked res2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Lock2 implements Runnable {

        @Override
        public void run() {
            synchronized (DeadLock.res2) {
                System.out.println("thread-2 locked res2");
                try {
                    Thread.sleep(300);
                    synchronized (DeadLock.res1) {
                        System.out.println("thread-2 locked res1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
