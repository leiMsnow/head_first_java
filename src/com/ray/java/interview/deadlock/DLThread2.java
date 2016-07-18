package com.ray.java.interview.deadlock;

/**
 * Created by dangdang on 7/18/16.
 */
public class DLThread2 {


    public synchronized void b1(DLThread1 thread1) {
        System.out.println(" 进入b1方法... ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("即将进入a2方法");
        thread1.a2();
        System.out.println("进入a2方法");

    }


    public synchronized void b2() {
        System.out.println("进入b2");
    }


}
