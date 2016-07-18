package com.ray.java.interview.lockandsync;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dangdang on 7/18/16.
 */
public class Task {

    public void doSomething() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("线程名称: ");
        stringBuffer.append(Thread.currentThread().getName());
        stringBuffer.append(",执行时间:");
        stringBuffer.append(Calendar.getInstance().get(Calendar.SECOND));
        stringBuffer.append("s");

        System.out.println(stringBuffer.toString());
    }


    static class TaskWithLock extends Task implements Runnable {

        Lock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                lock.lock();
                doSomething();
            } finally {
                lock.unlock();
            }

        }
    }

    static class TaskWithSync extends Task implements Runnable {

        @Override
        public void run() {
            synchronized (this.getClass()) {
                doSomething();
            }
        }
    }

    public static void runTasks(Class<? extends Runnable> clz) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("***********开始执行任务**************");
        for (int i = 0; i < 3; i++) {
            es.submit(clz.newInstance());
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("***********执行任务完毕**************");
        es.shutdown();
    }

    public static void main(String[] args) {

        try {
            runTasks(TaskWithLock.class);
            runTasks(TaskWithSync.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
