package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierExample {
    public static void main(String[] args) {
        int parties = 3;
        CyclicBarrier barrier = new CyclicBarrier(
            parties,
            () -> System.out.println("All reached checkpoint -> combine results")
        );

        Runnable stepper = () -> {
            try {
                for (int step = 1; step <= 3; step++) {
                    System.out.println(Thread.currentThread().getName() + " step " + step);
                    Thread.sleep(200);
                    barrier.await();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (BrokenBarrierException e) {
                System.out.println("Barrier broken, aborting " + Thread.currentThread().getName());
            }
        };

        new Thread(stepper).start();
        new Thread(stepper).start();
        new Thread(stepper).start();
    }
}
