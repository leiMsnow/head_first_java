package com.ray.java.basic.simple_thread;

/**
 * Created by dangdang on 5/17/16.
 */
public class BankAccount {

    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        this.balance = balance - amount;
    }
}
