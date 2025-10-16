package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemExample {
    private static final Semaphore SEM = new Semaphore(3, true);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        Runnable job = () -> {
            try {
                SEM.acquire();
                System.out.println(Thread.currentThread().getName() + " working");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                SEM.release();
            }
        };
        for (int i = 0; i < 10; i++) pool.submit(job);
        pool.shutdown();
    }
}
