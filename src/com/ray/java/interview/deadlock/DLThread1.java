package com.ray.java.interview.deadlock;

/**
 * Created by dangdang on 7/18/16.
 */
public class DLThread1 {


    public synchronized void a1(DLThread2 thread2) {
        System.out.println(" 进入a1方法... ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("即将进入b2方法");
        thread2.b2();
    }


    public synchronized void a2() {
        System.out.println("进入a2");
    }


}
