package com.ray.java.interview.lockandsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by dangdang on 7/18/16.
 */
public class Foo {
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public void read() {
        try {
            readLock.lock();
            Thread.sleep(1000);
            System.out.println("I'm reading...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(Object object) {
        writeLock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("I'm writing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

        Foo foo = new Foo();

        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            ex.submit((Runnable) () -> {
                foo.write("");
                foo.read();
            });
        }

        ex.shutdown();
    }

}
