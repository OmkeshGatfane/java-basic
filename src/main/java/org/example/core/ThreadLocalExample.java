package org.example.core;

public class ThreadLocalExample {
public static void main(String...args) {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    new Thread(()->{
        System.out.println("thread 1 local example value before set: " + threadLocal.get());
        System.out.println("Thread 1 started");
        threadLocal.set(100);
        System.out.println("Thread 1 value: " + threadLocal.get());
        threadLocal.remove();
        System.out.println("thread 1 local example value after remove: " + threadLocal.get());

    }).start();

    new Thread(()->{
        System.out.println("thread 2 local example value before set: " + threadLocal.get());
        System.out.println("Thread 2 started");
        threadLocal.set(200);
        System.out.println("Thread 2 value: " + threadLocal.get());
        threadLocal.remove();
        System.out.println("thread 2 local example value after remove: " + threadLocal.get());
    }).start();

    InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    new Thread (()->{
        System.out.println("InheritableThreadLocal value in Parent thread before set: " + inheritableThreadLocal.get());
        inheritableThreadLocal.set("Omkesh");
        System.out.println("InheritableThreadLocal value in Parent thread after set: " + inheritableThreadLocal.get());
        threadLocal.set(123);
        new Thread(()-> {
            System.out.println("InheritableThreadLocal value in Child thread: " + inheritableThreadLocal.get());
            System.out.println("ThreadLocal value in Child thread: " + threadLocal.get());
        }).start();
        System.out.println("ThreadLocal value in Parent thread: " + threadLocal.get());
    }).start();
}
}
