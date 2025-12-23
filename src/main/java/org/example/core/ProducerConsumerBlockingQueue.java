package org.example.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable {
    private final BlockingQueue<Integer> queue;

    ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0;i <100; i++) {
            try {
                queue.put(i);
                Thread.sleep(1000);
                System.out.println("Produced: " + i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class ConsumerBlockingQueue implements Runnable{
    private final BlockingQueue<Integer> queue;
    ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Integer item =queue.take();
                Thread.sleep(2000);
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producerThread = new Thread(new ProducerBlockingQueue(queue));
        Thread consumerThread = new Thread(new ConsumerBlockingQueue(queue));

        producerThread.start();
        consumerThread.start();
    }

}
