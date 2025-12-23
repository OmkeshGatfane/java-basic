package org.example.core;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe {
    public static void main(String[] args) {

        CopyOnWriteArrayList <Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        for (Integer number : numbers) {
            System.out.println(number);
            // This will NOT cause a ConcurrentModificationException
            numbers.add(6);
        }

    }
}
