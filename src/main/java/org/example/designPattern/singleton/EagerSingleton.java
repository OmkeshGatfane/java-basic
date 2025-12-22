package org.example.designPattern.singleton;

public class EagerSingleton {

//    Pros:
//    Simplicity: Easy to implement and understand.
//    Thread-Safety: Since the instance is created at class loading time, it is inherently thread-safe.
//
//    Cons:
//    Resource Wastage: If the instance is never used, the resources allocated for the instance are wasted.
//    Slow Startup: The class loading time may be increased due to the instance creation.


    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
        // private constructor to prevent instantiation
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
