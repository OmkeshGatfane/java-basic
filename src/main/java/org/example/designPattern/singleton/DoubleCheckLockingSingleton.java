package org.example.designPattern.singleton;

public class DoubleCheckLockingSingleton {
    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton(){
        // private constructor to prevent instantiation}
    }

    public static DoubleCheckLockingSingleton getInstance(){

        if(instance == null){
            synchronized (DoubleCheckLockingSingleton.class){
                if(instance == null){
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        return instance;
    }
}
