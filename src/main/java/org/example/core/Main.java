package org.example.core;


class MyThread extends Thread {

    public void run() {
        System.out.println("Thread started");
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Object sharedObj = new Object();
    public static void main(String[] args) {

        //very legacy style of creating thread by extending Thread class
        MyThread objTread  = new MyThread();
        objTread.start();

        //modern way of creating thread using lambda expression but not optimal way
        Thread objThread2 =  new Thread(()-> System.out.println("thread 2 is running "));
        objThread2.start();

        //optimal way of creating thread using Runnable interface , but lot ot boilerplate code
        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3 is running ");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread 3 is finished ");
            }
        };
        Thread objThread3 = new Thread(objRunnable);
        objThread3.setDaemon(true); //daemon thread will not block JVM to exit
        objThread3.start ();

        //Runnable is a functional interface so we can use lambda expression to create its object
        //functional interface is an interface which has only one abstract method
        Runnable objRunnable2 = ()-> System.out.println("thread 4 is running ");
        Thread objThread4 = new Thread(objRunnable2);
        objThread4.start();


        Runnable objRunnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("objRunnable1 is running ");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState());
                System.out.println(sharedObj.hashCode());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("objRunnable1 is finished ");
            }
        };

        Runnable objRunnable3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("objRunnable3 is running ");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getState());
                System.out.println(sharedObj.hashCode());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("objRunnable3 is finished ");
            }
        };

Thread objThread5 = new Thread(objRunnable1);
Thread objThread6 = new Thread(objRunnable3);
objThread5.start();
objThread6.start();
        System.out.println("Main thread is Finished ");




    }
}

