package org.example.designPattern.singleton;

public class RealTimeSingleton {
    private static RealTimeSingleton instance;

    // prevent other classes from instantiating
    private RealTimeSingleton() {
        // prevent object creation from reflection
        if(instance !=null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        System.out.println("RealTimeSingleton instance created.");
    }

    // prevent instance creation during deserialization
    public Object readResolve(){
        return getInstance();
    }

    //prevent instance creation by cloning
    @Override
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cloning of this singleton is not allowed");
    }

    // synchronized to make thread-safe
    public static RealTimeSingleton getInstance(){
        if(instance == null){
            synchronized (RealTimeSingleton.class){
                if (instance == null){
                    instance = new RealTimeSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        RealTimeSingleton singleton1 = RealTimeSingleton.getInstance();
        RealTimeSingleton singleton2 = RealTimeSingleton.getInstance();

        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
    }

    //use enum to prevent serialization and reflection issues - best approach
}
