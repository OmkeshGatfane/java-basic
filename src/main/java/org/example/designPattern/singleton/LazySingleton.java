package org.example.designPattern.singleton;

public class LazySingleton {
//    Pros:
//    Resource Efficiency: The instance is only created if needed, saving resources.
//    Improved Startup Time: No delay due to instance creation during class loading.
//
//    Cons:
//    Complexity: Requires additional logic to ensure thread safety.
//    Thread-Safety Issues: Without proper synchronization, multiple threads could create multiple instances.

    private static LazySingleton instance;

    private LazySingleton() {
        // private constructor to prevent instantiation
    }

    public static  LazySingleton getInstance(){

        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
