package com.ray.java.interview.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 哲学家在思考和进食中...
 * Created by dangdang on 5/19/16.
 */
public class DeadLockingDiningPhilosophers {

    public static void main(String[] args) {

        int ponder = 1;
        int size = 5;

        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
        }

    }

}
