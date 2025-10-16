package org.example;

import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    static class Account {
        int balance;
        final ReentrantLock lock = new ReentrantLock();

        Account(int balance) {
            this.balance = balance;
        }
    }

    static void transfer(Account from, Account to, int amount) {
        synchronized (to.lock) {
            System.out.println(Thread.currentThread().getName() + " locked FROM");
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {
            }
            synchronized (from.lock) {
                System.out.println(Thread.currentThread().getName() + " locked TO");
                from.balance -= amount;
                to.balance += amount;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(() -> transfer(a, b, 100), "T1");
        Thread t2 = new Thread(() -> transfer(b, a, 200), "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("A =" + a.balance + " B =" + b.balance);
    }
}