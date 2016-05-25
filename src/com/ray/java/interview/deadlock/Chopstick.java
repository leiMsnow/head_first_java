package com.ray.java.interview.deadlock;

/**
 * 筷子
 * Created by dangdang on 5/19/16.
 */
public class Chopstick {

    private boolean taken = false;

    public synchronized void drop() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    public synchronized void take() {
        taken = false;
        notifyAll();
    }
}
