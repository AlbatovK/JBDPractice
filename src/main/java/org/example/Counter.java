package org.example;


import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private long count = 0;
    private final ReentrantLock lock = new ReentrantLock(true);

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public long getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Runnable decrement = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        };

        Thread thread1 = new Thread(increment);
        Thread thread2 = new Thread(decrement);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getCount());
    }
}
