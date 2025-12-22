package org.example.designPattern.singleton;

//Enum instances are inherently thread-safe, and the JVM ensures that the instance is created only once,
// even in a multithreaded environment.
//Enums are resistant to reflection attacks.
// It is not possible to use reflection to create another instance of an enum type.
//The Java serialization mechanism guarantees that enum values are always serialized as a single instance,
// maintaining the singleton property without additional code.

enum EnumSingletonType {
    INSTANCE;

    public void someMethod() {
        System.out.println("Method called on Enum Singleton");
    }
}
public class EnumSingleton {
    public static void main(String[] args) {
        EnumSingletonType singletonInstance1 = EnumSingletonType.INSTANCE;
        singletonInstance1.someMethod();

        EnumSingletonType singletonInstance2 = EnumSingletonType.INSTANCE;
        System.out.println("Are both instances the same? " + (singletonInstance1 == singletonInstance2));
    }
}

