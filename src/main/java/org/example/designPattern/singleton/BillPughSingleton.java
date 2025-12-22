package org.example.designPattern.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){
        // private constructor to prevent instantiation
    }

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
