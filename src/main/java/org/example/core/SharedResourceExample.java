package org.example.core;

class SharedResource {
    private  boolean flag = false;

    public synchronized boolean isFlag() {
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }

}
public class SharedResourceExample {
    public static void main(String...args){
        SharedResource sharedResource = new SharedResource();

        new Thread (()->{
            System.out.println("Thread 1 started");
            try {
                Thread.sleep(2000);
                System.out.println("Thread 1 finished");
                sharedResource.setFlag(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread (()->{
            System.out.println("Thread 2 started");
            while (!sharedResource.isFlag()){
                //busy wait
            }
            System.out.println("Thread 2 finished");
        }).start();
    }

}
