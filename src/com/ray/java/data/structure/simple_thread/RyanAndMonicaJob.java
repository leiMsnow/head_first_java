package com.ray.java.data.structure.simple_thread;

/**
 * 使用synchronized关键字同步方法;
 * 每个java对象都有一个锁,每个锁只有一把钥匙.
 * 通常对象都没上锁,也没有人在乎这件事.
 * 但如果对象有同步化的方法,则线程只能在取得钥匙的情况下进入线程.
 * 也就是说并没有其他线程已经进入的情况下才能进入.
 * PS: 锁不是配在方法上的,而是配上对象上.
 * Created by dangdang on 5/17/16.
 */
public class RyanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread ryan = new Thread(theJob, "ryan");
        Thread monica = new Thread(theJob, "monica");
        ryan.start();
        monica.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw1");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}
