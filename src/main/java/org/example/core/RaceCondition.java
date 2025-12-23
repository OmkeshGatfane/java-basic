package org.example.core;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
public class RaceCondition {
    public static void main(String...args) {
        SharedCounter sharedCounter = new SharedCounter();

//        thread1
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedCounter.increment();
            }
        }).start();


//        thread2
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Final Counter Value: " + sharedCounter.getCounter());
        }).start();


    }
}
