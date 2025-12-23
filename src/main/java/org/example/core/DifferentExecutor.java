package org.example.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DifferentExecutor {
    public static void main(String...args){

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor ");
        for (int i = 0 ; i<5;i++){
            final int taskId = i;
            singleThreadExecutor.execute(()->
                System.out.println("Task "+ taskId + " executed by " + Thread.currentThread().getName())
            );
        }
        singleThreadExecutor.shutdown();

        //Fixed Thread Pool Executor
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("Fixed Thread Pool Executor ");
        for (int i = 0 ; i<5;i++){
            final int taskId = i;
            fixedThreadPool.execute(()->
                System.out.println("Fixed Thread Task "+ taskId + " executed by " + Thread.currentThread().getName())
            );
        }
        fixedThreadPool.shutdown();

        //Cached Thread Pool Executor
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("Cached Thread Pool Executor ");
        for (int i = 0 ; i<5;i++){
            final int taskId = i;
            cachedThreadPool.execute(()->
                    System.out.println("Cached Thread Task "+ taskId + " executed by " + Thread.currentThread().getName())
            );
        }
        cachedThreadPool.shutdown();

        //Scheduled Thread Pool Executor
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("Scheduled Thread Pool Executor ");
        for (int i = 0 ; i<5;i++){
            final int taskId = i;
            scheduledThreadPool.execute(()->
                    System.out.println("Scheduled Thread Task "+ taskId + " executed by " + Thread.currentThread().getName())
            );
        }
        scheduledThreadPool.shutdown();
    }
}
