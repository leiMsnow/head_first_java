package com.ray.java.interview.deadlock;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家
 * Created by dangdang on 5/19/16.
 */
public class Philosopher implements Runnable {

    Chopstick left;
    Chopstick right;
    int ident;
    int ponder;
    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
        this.left = left;
        this.right = right;
        this.ident = ident;
        this.ponder = ponder;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                System.out.println(this + " " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
                System.out.println(this + " " + "drop chopstick");
            }

        } catch (InterruptedException ex) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }

    private void pause() throws InterruptedException {
        if (ponder == 0) {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponder * 250));
        }
    }

    @Override
    public String toString() {
        return "Philosopher" + ident;
    }
}
