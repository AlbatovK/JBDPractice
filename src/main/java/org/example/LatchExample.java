package org.example;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
    public static void main(String[] args) throws InterruptedException {
        int workers = 3;
        CountDownLatch ready = new CountDownLatch(workers);

        for (int i = 0; i < workers; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 + id * 100);
                    System.out.println("Worker " + id + " ready");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    ready.countDown();
                }
            }).start();
        }

        System.out.println("Main waits...");
        ready.await();
        System.out.println("Go!");
    }
}
