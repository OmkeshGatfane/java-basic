package org.example;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class PlatformThreadsExample {

    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static void main(String... args) throws InterruptedException {

        final int numberOfThreads = 1000000;

        List<Thread> threadList = new ArrayList<>();
        Runnable objRunnable =new Runnable(){
            @Override
                public void run(){
                System.out.println("fetching data form api ");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("data fetched successfully ");
            }
        };

        for(int i =0 ; i< numberOfThreads; i++){
            Thread thread = Thread.ofVirtual().unstarted(objRunnable);
//            thread.setDaemon(true);
            thread.setName("Thread-"+i);
            thread.start();
            System.out.println("Thread number "+ i + " started ");
            threadList.add(thread);
        }

        for (Thread thread : threadList) {
            thread.join();
            System.out.println(thread.getName() + " Completed ");
        }
    }
}
