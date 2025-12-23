package org.example.designPattern.factory.wrapper;

public class TextDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opening Text Document");
    }

    @Override
    public void close() {
        System.out.println("Closing Text Document");
    }

    @Override
    public void save() {
        System.out.println("Saving Text Document");
    }
}
